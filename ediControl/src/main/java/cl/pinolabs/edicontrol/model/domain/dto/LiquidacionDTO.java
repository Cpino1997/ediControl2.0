package cl.pinolabs.edicontrol.model.domain.dto;

import lombok.Data;

@Data
public class LiquidacionDTO {
    private Integer id;
    private Integer liquido;
    private Integer bruto;
    private Integer descuentos;
    private Integer movilizacion;
    private Integer viatico;
    private Integer imponible;
    private Integer asistencias;
    private Integer ausencias;
    private Integer colacion;
    private Integer tributable;
    private Integer idTrabajador;
    private TrabajadorDTO trabajador;
    private boolean pagada;
    private String fecha;
}
