package cl.pinolabs.edicontrol.model.domain.dto.seguridad;

public class MensajeResponse {
    private String message;


    public MensajeResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
