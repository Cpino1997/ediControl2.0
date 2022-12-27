package cl.pinolabs.edicontrol.model.persistence.mapper;

import cl.pinolabs.edicontrol.model.domain.dto.ComunaDTO;
import cl.pinolabs.edicontrol.model.persistence.entity.Comuna;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RegionMapper.class})
public interface ComunaMapper {

    ComunaDTO toComunaDTO(Comuna comuna);
    List<ComunaDTO> toComunasDTO(List<Comuna> comunas);
    @InheritInverseConfiguration
    Comuna toComuna(ComunaDTO comunaDTO);
}
