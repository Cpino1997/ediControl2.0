package cl.pinolabs.edicontrol.model.domain.dto.seguridad;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class RegistroRequest {
    @NotBlank(message = "El usuario no puede estar vacio")
    @Size(min = 4, max = 20,message = "error el usuario debe tener entre 4 a 20 caracteres")
    private String username;

    @NotBlank(message = "El correo no puede estar en blanco")
    @Size(max = 50, message = "el tamaño maximo para el correo son 60 caracteres")
    @Email
    private String email;
    private Set<String> role;

    @NotBlank(message = "La contraseña debe tener entre 6 y 40 caracteres")
    @Size(min = 6, max = 40)
    private String password;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Set<String> getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
