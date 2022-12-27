package cl.pinolabs.edicontrol.model.persistence.mapper;


import cl.pinolabs.edicontrol.model.domain.dto.TrabajadorDTO;
import cl.pinolabs.edicontrol.model.persistence.entity.Trabajador;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ComunaMapper.class, AFPMapper.class, SaludMapper.class , ContratoMapper.class, CuentaMapper.class})
public interface TrabajadorMapper {
    TrabajadorDTO toTrabajadorDTO(Trabajador trabajador);
    List<TrabajadorDTO> toTrabajadoresDTO(List<Trabajador> trabajadores);
    @InheritInverseConfiguration
    Trabajador toTrabajador(TrabajadorDTO trabajadorDTO);
}
