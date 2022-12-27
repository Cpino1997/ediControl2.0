package cl.pinolabs.edicontrol.model.persistence.mapper;

import cl.pinolabs.edicontrol.model.domain.dto.SaludDTO;
import cl.pinolabs.edicontrol.model.persistence.entity.Salud;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaludMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "descuento", target = "descuento")
    @Mapping(source = "nombre", target = "nombre")
    SaludDTO toSaludDTO(Salud salud);
    List<SaludDTO> toSaludDTOs(List<Salud> saluds);
    @InheritInverseConfiguration
    Salud toSalud(SaludDTO saludDTO);
}
