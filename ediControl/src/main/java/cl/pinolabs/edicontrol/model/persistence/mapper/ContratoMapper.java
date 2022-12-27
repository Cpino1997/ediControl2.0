package cl.pinolabs.edicontrol.model.persistence.mapper;

import cl.pinolabs.edicontrol.model.domain.dto.ContratoDTO;
import cl.pinolabs.edicontrol.model.persistence.entity.Contrato;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CargoMapper.class})
public interface ContratoMapper {
    @Mapping(source = "cargo", target = "cargo")
    ContratoDTO toContratoDTO(Contrato contrato);
    List<ContratoDTO> toContratosDTO(List<Contrato> contratos);
    @InheritInverseConfiguration
    Contrato toContrato(ContratoDTO contratoDTO);
}
