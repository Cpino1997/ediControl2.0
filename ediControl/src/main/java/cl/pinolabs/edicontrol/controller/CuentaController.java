package cl.pinolabs.edicontrol.controller;

import cl.pinolabs.edicontrol.model.domain.dto.BancoDTO;
import cl.pinolabs.edicontrol.model.domain.dto.CuentaDTO;
import cl.pinolabs.edicontrol.model.domain.dto.TipoCuentaDTO;
import cl.pinolabs.edicontrol.model.domain.service.BancoService;
import cl.pinolabs.edicontrol.model.domain.service.CuentaService;
import cl.pinolabs.edicontrol.model.domain.service.TipoCuentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api")
public class CuentaController {
    private final BancoService bancoService;
    private final CuentaService cuentaService;
    private final TipoCuentaService tipoService;

    public CuentaController(BancoService bancoService, CuentaService cuentaService, TipoCuentaService tipoService) {
        this.bancoService = bancoService;
        this.cuentaService = cuentaService;
        this.tipoService = tipoService;
    }
    @GetMapping("/bancos")
    public ResponseEntity<List<BancoDTO>> findAllBancos(){
        return bancoService.findAll()
                .map(bancos -> new ResponseEntity<>(bancos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/banco/{id}")
    public ResponseEntity<BancoDTO> findOneBanco(@PathVariable("id") int id){
        return bancoService.findById(id)
                .map(banco -> new ResponseEntity<>(banco, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/tipos")
    public ResponseEntity<List<TipoCuentaDTO>> findAllTipos(){
        return tipoService.findAll()
                .map(tipoCuentaDTOS -> new ResponseEntity<>(tipoCuentaDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/tipos/{id}")
    public ResponseEntity<TipoCuentaDTO> findOneTipo(@PathVariable("id") int id){
        return tipoService.findById(id)
                .map(tipoCuentaDTO -> new ResponseEntity<>(tipoCuentaDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /* Servicio de cuentas */
    @GetMapping("/cuentas")
    public ResponseEntity<List<CuentaDTO>> findAllCuentas(){
        return cuentaService.findAll()
                .map(cuentas -> new ResponseEntity<>(cuentas, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/cuentas/{id}")
    public ResponseEntity<CuentaDTO> findOneCuenta(@PathVariable("id") int id){
        return cuentaService.findById(id)
                .map(cuentaDTO -> new ResponseEntity<>(cuentaDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/cuentas/{id}")
    public ResponseEntity<CuentaDTO> updateCuenta(@PathVariable(value = "id") int id, @Valid @RequestBody CuentaDTO cuentaDTO) {
        CuentaDTO reg = cuentaService.findById(id).get();
        reg.setId(cuentaDTO.getId());
        reg.setNumero(cuentaDTO.getNumero());
        reg.setIdBanco(cuentaDTO.getIdBanco());
        reg.setIdTipo(cuentaDTO.getIdTipo());
        final CuentaDTO update = cuentaService.save(reg);
        return ResponseEntity.ok(update);
    }
    @PostMapping("/cuenta")
    public ResponseEntity<CuentaDTO> save(@Valid @RequestBody CuentaDTO cuentaDTO) {
        return new ResponseEntity<>(cuentaService.save(cuentaDTO) ,HttpStatus.OK);
    }
    @DeleteMapping("/cuenta/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        if (cuentaService.delete(id)){
            return ResponseEntity.ok("Cuenta Eliminada con Exito!");
        } else {
            return ResponseEntity.badRequest().body("no se a podido eliminar la Cuenta con id "+id);
        }
    }
}
