package cl.pinolabs.edicontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class EdiControlApplication {
	public static void main(String[] args) {
		SpringApplication.run(EdiControlApplication.class, args);
	}

}