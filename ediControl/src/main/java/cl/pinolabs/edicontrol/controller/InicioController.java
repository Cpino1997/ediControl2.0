package cl.pinolabs.edicontrol.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping
public class InicioController {
    @GetMapping("/")
    public String index(){
        return"Bienvenido explorador, nuestros servicios se encuentran funcionando a la perfeccion!";
    }

}
