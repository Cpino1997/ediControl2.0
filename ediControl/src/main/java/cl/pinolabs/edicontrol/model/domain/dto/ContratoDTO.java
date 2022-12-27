package cl.pinolabs.edicontrol.model.domain.dto;

import cl.pinolabs.edicontrol.model.domain.dto.CargoDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContratoDTO {
    private Integer id;
    private Integer idCargo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private CargoDTO cargo;
}
