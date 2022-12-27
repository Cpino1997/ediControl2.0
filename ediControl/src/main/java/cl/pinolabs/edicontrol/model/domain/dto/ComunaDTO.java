package cl.pinolabs.edicontrol.model.domain.dto;

import lombok.Data;

@Data
public class ComunaDTO {

    private Integer id;
    private Integer idRegion;
    private String nombre;
    private RegionDTO region;
}
