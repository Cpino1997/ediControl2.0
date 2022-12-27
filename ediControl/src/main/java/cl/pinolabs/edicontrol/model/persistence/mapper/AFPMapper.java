package cl.pinolabs.edicontrol.model.persistence.mapper;

import cl.pinolabs.edicontrol.model.domain.dto.AfpDTO;
import cl.pinolabs.edicontrol.model.persistence.entity.Afp;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AFPMapper {
    AfpDTO toAFPDTO(Afp afp);
    List<AfpDTO> toAFPSDTO(List<Afp> afps);
    @InheritInverseConfiguration
    Afp toAFP(AfpDTO afpDTO);

}
