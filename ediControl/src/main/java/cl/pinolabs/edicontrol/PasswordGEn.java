package cl.pinolabs.edicontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGEn {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("encoder:  " + encoder.encode("holanda"));
    }


}
