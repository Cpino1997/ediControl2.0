package cl.pinolabs.edicontrol.controller;

import cl.pinolabs.edicontrol.model.domain.dto.AfpDTO;
import cl.pinolabs.edicontrol.model.domain.dto.SaludDTO;
import cl.pinolabs.edicontrol.model.domain.service.AfpService;
import cl.pinolabs.edicontrol.model.domain.service.SaludService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api")
public class DescuentosController {

    private final AfpService afpService;
    private final SaludService saludService;

    public DescuentosController(AfpService afpService, SaludService saludService) {
        this.afpService = afpService;
        this.saludService = saludService;
    }

    @GetMapping("/afps")
    public ResponseEntity<List<AfpDTO>> getAllAfps(){
        return afpService.findAll()
                .map(afps -> new ResponseEntity<>(afps, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/afps/{id}")
    public ResponseEntity<AfpDTO> getAfpById(@PathVariable("id") int id){
        return afpService.findById(id)
                .map(afpDTO -> new ResponseEntity<>(afpDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/test")
    public String postBody(@RequestBody String nombre) {
        String resultado ="";
        System.out.println(nombre);
        if(afpService.exitsByNombre(nombre)){
            resultado = "existe";
        }else{
            resultado = "no existe";
        }
        return resultado;

    }

    @GetMapping("/saluds")
    public ResponseEntity<List<SaludDTO>> getAllSaluds(){
        return saludService.findAll()
                .map(saluds -> new ResponseEntity<>(saluds, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/saluds/{id}")
    public ResponseEntity<SaludDTO> getSaludById(@PathVariable("id") int id){
        return saludService.findById(id)
                .map(saludDTO -> new ResponseEntity<>(saludDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
