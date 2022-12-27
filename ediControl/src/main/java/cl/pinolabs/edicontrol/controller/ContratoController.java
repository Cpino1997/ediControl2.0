package cl.pinolabs.edicontrol.controller;

import cl.pinolabs.edicontrol.model.domain.dto.CargoDTO;
import cl.pinolabs.edicontrol.model.domain.dto.ContratoDTO;
import cl.pinolabs.edicontrol.model.domain.service.CargoService;
import cl.pinolabs.edicontrol.model.domain.service.ContratoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api")
public class ContratoController {

    private final CargoService cargoService;
    private final ContratoService contratoService;

    public ContratoController(CargoService cargoService, ContratoService contratoService) {
        this.cargoService = cargoService;
        this.contratoService = contratoService;
    }

    @GetMapping("/cargos")
    private ResponseEntity<List<CargoDTO>> findAllCargos(){
        return cargoService.findAll()
                .map(cargos -> new ResponseEntity<>(cargos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /* Contratos Service */
    @GetMapping("/contratos")
    private ResponseEntity<List<ContratoDTO>> findAllContratos(){
        return contratoService.findAll()
                .map(contratos -> new ResponseEntity<>(contratos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/contratos/{id}")
    public ResponseEntity<ContratoDTO> findOneContrato(@PathVariable("id") int id){
        return contratoService.findById(id)
                .map(contrato -> new ResponseEntity<>(contrato, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/contratos/{id}")
    public ResponseEntity<ContratoDTO> updateCuenta(@PathVariable(value = "id") int id, @Valid @RequestBody ContratoDTO contratoDTO) {
        ContratoDTO reg = contratoService.findById(id).get();
        reg.setId(contratoDTO.getId());
        reg.setIdCargo(contratoDTO.getIdCargo());
        reg.setFechaFin(contratoDTO.getFechaFin());
        reg.setFechaInicio(contratoDTO.getFechaInicio());
        final ContratoDTO update = contratoService.save(reg);
        return ResponseEntity.ok(update);
    }
    @PostMapping("/contratos")
    public ResponseEntity<ContratoDTO> save(@Valid @RequestBody ContratoDTO contratoDTO) {
        return new ResponseEntity<>(contratoService.save(contratoDTO) ,HttpStatus.OK);
    }
    @DeleteMapping("/contratos/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        if (contratoService.delete(id)){
            return ResponseEntity.ok("Cuenta Eliminada con Exito!");
        } else {
            return ResponseEntity.badRequest().body("no se a podido eliminar la Cuenta con id "+id);
        }
    }

}
