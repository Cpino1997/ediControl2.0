package cl.pinolabs.edicontrol.model.persistence.mapper;

import cl.pinolabs.edicontrol.model.domain.dto.RegionDTO;
import cl.pinolabs.edicontrol.model.persistence.entity.Region;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegionMapper {
    RegionDTO toRegionDTO(Region region);
    List<RegionDTO> toRegionesDTO(List<Region> regiones);
    @InheritInverseConfiguration
    Region toRegion(RegionDTO regionDTO);
}
