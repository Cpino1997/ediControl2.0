package cl.pinolabs.edicontrol.controller;

import cl.pinolabs.edicontrol.model.domain.dto.*;
import cl.pinolabs.edicontrol.model.domain.service.*;
import cl.pinolabs.edicontrol.model.persistence.crud.TrabajadorCrud;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api")
public class PersonalController {

    private final TrabajadorService trabajadorService;

    private final ComunaService comunaService;
    private final RegionService regionService;

    public PersonalController( TrabajadorService trabajadorService, ComunaService comunaService, RegionService regionService) {
        this.trabajadorService = trabajadorService;
        this.comunaService = comunaService;
        this.regionService = regionService;
    }


    /* trabajador service */
    @GetMapping("/trabajadores")
    private ResponseEntity<List<TrabajadorDTO>> findAllTrabajadores(){
        return trabajadorService.findAll()
                .map(trabajadores -> new ResponseEntity<>(trabajadores, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/trabajadores/{id}")
    public ResponseEntity<TrabajadorDTO> findOneTrabajador(@PathVariable("id") int id){
        return trabajadorService.findById(id)
                .map(trabajador -> new ResponseEntity<>(trabajador, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/trabajadores/{id}")
    public ResponseEntity<TrabajadorDTO> updateTrabajador(@PathVariable(value = "id") int id, @Valid @RequestBody TrabajadorDTO trabajadorDTO) {
        TrabajadorDTO reg = trabajadorService.findById(id).get();
        reg.setId(trabajadorDTO.getId());
        reg.setNombre(trabajadorDTO.getNombre());
        reg.setCorreo(trabajadorDTO.getCorreo());
        reg.setDireccion(trabajadorDTO.getDireccion());
        reg.setRut(trabajadorDTO.getRut());
        reg.setTelefono(trabajadorDTO.getTelefono());

        reg.setIdContrato(trabajadorDTO.getIdContrato());
        reg.setIdCuenta(trabajadorDTO.getIdCuenta());
        reg.setIdComuna(trabajadorDTO.getIdComuna());
        reg.setIdAfp(trabajadorDTO.getIdAfp());
        reg.setIdSalud(trabajadorDTO.getIdSalud());

        final TrabajadorDTO update = trabajadorService.save(reg);
        return ResponseEntity.ok(update);
    }
    @PostMapping("/trabajadores")
    public ResponseEntity<TrabajadorDTO> saveTrabajador(@Valid @RequestBody TrabajadorDTO trabajadorDTO) {
        return new ResponseEntity<>(trabajadorService.save(trabajadorDTO) ,HttpStatus.OK);
    }
    @DeleteMapping("/trabajadores/{id}")
    public ResponseEntity<String> deleteTrabajador(@PathVariable("id") int id){
        if (trabajadorService.delete(id)){
            return ResponseEntity.ok("Cuenta Eliminada con Exito!");
        } else {
            return ResponseEntity.badRequest().body("no se a podido eliminar la Cuenta con id "+id);
        }
    }

    /* Comuna Service */
    @GetMapping("/comunas")
    public ResponseEntity<List<ComunaDTO>> findAllComunas(){
        return comunaService.findAll()
                .map(comunas -> new ResponseEntity<>(comunas, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/comunas/{id}")
    public ResponseEntity<ComunaDTO> findOneComunas(@PathVariable("id") int id){
        return comunaService.findById(id)
                .map(comunaDTO -> new ResponseEntity<>(comunaDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/comunas/reg/{id}")
    public ResponseEntity<List<ComunaDTO>>findByIdRegion(@PathVariable("id") int id){
        return comunaService.findByIdRegion(id)
                .map(comunaDTO -> new ResponseEntity<>(comunaDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /* region service */
    @GetMapping("/regiones")
    public ResponseEntity<List<RegionDTO>> findAllRegiones(){
        return regionService.findAll()
                .map(regiones -> new ResponseEntity<>(regiones, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/regiones/{idRegion}")
    public ResponseEntity<RegionDTO> findById(@PathVariable("idRegion") int idRegion){
        return regionService.findById(idRegion)
                .map(regionDTO -> new ResponseEntity<>(regionDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
