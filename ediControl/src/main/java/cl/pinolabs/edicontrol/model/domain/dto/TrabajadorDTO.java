package cl.pinolabs.edicontrol.model.domain.dto;

import lombok.Data;

@Data
public class TrabajadorDTO {
    private  Integer id;
    private String nombre;
    private Integer rut;
    private String direccion;
    private String correo;
    private Integer telefono;
    private Integer idComuna;
    private Integer idAfp;
    private Integer idSalud;
    private Integer idCuenta;
    private Integer idContrato;
    /* Objetos */
    private ComunaDTO comuna;
    private AfpDTO afp;
    private SaludDTO salud;
    private CuentaDTO cuenta;
    private ContratoDTO contrato;
    private boolean activo;
}
