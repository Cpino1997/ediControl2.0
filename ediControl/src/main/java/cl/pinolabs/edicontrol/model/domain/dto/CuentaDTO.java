package cl.pinolabs.edicontrol.model.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CuentaDTO {
    private Integer id;
    @NotNull(message = "El tipo de cuenta no debe estar vacio!")
    private Integer idTipo;
    @NotNull(message = "El banco no debe estar vacio!")
    private Integer idBanco;

    private TipoCuentaDTO tipoCuentaDTO;
    private BancoDTO bancoDTO;

    @NotBlank(message = "El numero de cuenta no debe estar vacio!")
    @NotNull(message = "El numero de cuenta no debe estar vacio!")
    private String numero;
}