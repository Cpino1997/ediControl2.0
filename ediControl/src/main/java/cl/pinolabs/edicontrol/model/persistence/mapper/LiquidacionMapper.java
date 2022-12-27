package cl.pinolabs.edicontrol.model.persistence.mapper;


import cl.pinolabs.edicontrol.model.domain.dto.LiquidacionDTO;
import cl.pinolabs.edicontrol.model.persistence.entity.Liquidacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TrabajadorMapper.class})
public interface LiquidacionMapper {

    LiquidacionDTO toLiquidacionDTO(Liquidacion liquidacion);

    List<LiquidacionDTO> toLiquidacionesDTO(List<Liquidacion> liquidaciones);
    @InheritInverseConfiguration
    Liquidacion toLiquidacion(LiquidacionDTO liquidacionDTO);
}
