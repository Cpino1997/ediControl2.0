package cl.pinolabs.edicontrol.controller;

import cl.pinolabs.edicontrol.model.domain.dto.*;
import cl.pinolabs.edicontrol.model.domain.service.*;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.openhtmltopdf.util.XRLog;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api")
public class LiquidacionesController {
    private static Log log = LogFactory.getLog(LiquidacionesController.class);
    private final LiquidacionService service;
    private final AfpService afpService;
    private final SaludService sService;
    private final CargoService cService;
    private final ContratoService contratoService;
    private final TrabajadorService trabajadorService;
    @Value("report.template.path")
    private String reportFilePath;
    @Autowired
    private TemplateEngine templateEngine;
    public LiquidacionesController(LiquidacionService service, AfpService afpService, SaludService sService, CargoService cService, ContratoService contratoService, TrabajadorService trabajadorService) {
        this.service = service;
        this.afpService = afpService;
        this.sService = sService;
        this.cService = cService;
        this.contratoService = contratoService;
        this.trabajadorService = trabajadorService;
    }

    /* Liquidaciones */
    @GetMapping("/liquidaciones")
    public ResponseEntity<List<LiquidacionDTO>> findAllLiquidaciones(){
        return service.findAll()
                .map(liquidaciones -> new ResponseEntity<>(liquidaciones, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/liquidaciones/{idLiquidacion}")
    public ResponseEntity<LiquidacionDTO> findByIdliquidacion(@PathVariable("idLiquidacion") int idLiquidacion){
        return service.findById(idLiquidacion)
                .map(liquidacionDTO -> new ResponseEntity<>(liquidacionDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/liquidaciones")
    public ResponseEntity<LiquidacionDTO> saveLiquidacion(@RequestBody LiquidacionDTO liquidacionDTO) {
        LiquidacionDTO nueva = new LiquidacionDTO();
        Optional<CargoDTO> cargo = Optional.empty();
        Optional<ContratoDTO> contrato;
        Optional<SaludDTO> salud = Optional.empty();
        Optional<AfpDTO> afp = Optional.empty();
        Optional<TrabajadorDTO> trabajador = trabajadorService.findById(liquidacionDTO.getIdTrabajador());
        if(trabajador.isPresent()){
            contrato = contratoService.findById(trabajador.get().getIdContrato());
            if(contrato.isPresent()){
                cargo = cService.findById(contrato.get().getIdCargo());
            }
        }
        if(trabajador.isPresent()){
            salud = sService.findById(trabajador.get().getIdSalud());
            afp = afpService.findById(trabajador.get().getIdAfp());
        }
        Integer asistidos, ausencias;
            asistidos = liquidacionDTO.getAsistencias();
            ausencias = liquidacionDTO.getAusencias();
        Integer sueldo=0;
        int idCargo = 0;
        if(cargo.isPresent()){
            sueldo = cargo.get().getSueldo();
            idCargo = cargo.get().getId();
        }

        //calculo trabajadores partime
        if(idCargo == 2 ){
            float valorDia = 24000, descuentos = 0, base, liquido, tributable,viatico;
            base = valorDia * asistidos;
            if(salud.isPresent() && afp.isPresent()) {
                float total = (salud.get().getDescuento() + afp.get().getDescuento());
                descuentos = base * total/100;
            }
            tributable = base - descuentos;
            viatico = base - tributable;
            liquido = viatico + tributable;

            nueva.setId(0);
            nueva.setIdTrabajador(liquidacionDTO.getIdTrabajador());
            nueva.setTrabajador(liquidacionDTO.getTrabajador());
            nueva.setAsistencias(liquidacionDTO.getAsistencias());
            nueva.setAusencias(liquidacionDTO.getAusencias());
            nueva.setTributable((int) tributable);
            nueva.setBruto((int) base);
            nueva.setLiquido((int) liquido);
            nueva.setColacion(0);
            nueva.setViatico((int) viatico);
            nueva.setMovilizacion(0);
            nueva.setDescuentos((int) descuentos);
            return new ResponseEntity<>(service.save(nueva) ,HttpStatus.OK);
        }
        //fin calculo partime
        //calculo trabajadores Fulltime
        int valorDia = sueldo/30;
        float descuentos = 0;
        int base = sueldo - (valorDia * ausencias);
        float aux=0;
        if(salud.isPresent() && afp.isPresent()) {
            float total = (salud.get().getDescuento() + afp.get().getDescuento());
            descuentos = total * base/100;
            aux = total * sueldo/100;
        }
        int tributable = (int) (base - descuentos);
        int valorBonos, baseBonos = (int) (sueldo - aux);
        if(idCargo == 4){
            valorBonos = 400000 - baseBonos;
        }else{
            valorBonos = 450000 - baseBonos;
        }
        int valorBonoDia =(valorBonos/30);
        int bonos = (valorBonos - (valorBonoDia * ausencias));
        int asignacion = bonos/2;
        int liquido =(tributable + bonos);
        int bruto =(base + bonos);
        nueva.setId(0);
        nueva.setIdTrabajador(liquidacionDTO.getIdTrabajador());
        nueva.setTrabajador(liquidacionDTO.getTrabajador());
        nueva.setAsistencias(liquidacionDTO.getAsistencias());
        nueva.setAusencias(liquidacionDTO.getAusencias());
        nueva.setTributable(tributable);
        nueva.setBruto( bruto);
        nueva.setImponible(base);
        nueva.setLiquido(liquido);
        nueva.setColacion(asignacion);
        nueva.setViatico(0);
        nueva.setMovilizacion(asignacion);
        nueva.setDescuentos((int) descuentos);
        System.out.println(nueva + "El Bruto es = "+ bruto);
        // cierre trabajadores fulltime
        return new ResponseEntity<>(service.save(nueva) ,HttpStatus.OK);
    }

    @GetMapping("/liquidaciones/{idLiquidicion}/pdf")
    public void descargarPDF(@PathVariable("idLiquidicion") int id, HttpServletResponse response) throws Exception {
        Optional<LiquidacionDTO> opLiquidacion = service.findById(id);
        LiquidacionDTO liquidacion = opLiquidacion.get();

        // Configurar la respuesta HTTP
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"mi-pdf.pdf\"");

        // Crear el PDF utilizando Thymeleaf
        Context context = new Context();
        context.setVariable("liquidacion", liquidacion);
        String html = templateEngine.process("plantilla", context);
        try {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            XRLog.setLoggingEnabled(false);
            builder.withHtmlContent(html, "/");
            builder.toStream(response.getOutputStream());
            builder.run();
        } catch (Exception e) {
            log.error("Exception while generating pdf : {}", e);
        }
    }

}