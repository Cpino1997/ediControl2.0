package cl.pinolabs.edicontrol.model.persistence.mapper;

import cl.pinolabs.edicontrol.model.domain.dto.BancoDTO;
import cl.pinolabs.edicontrol.model.persistence.entity.Banco;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BancoMapper {

    BancoDTO toBancoDTO(Banco banco);
    List<BancoDTO> toBancosDTO(List<Banco> bancos);
    @InheritInverseConfiguration
    Banco toBanco(BancoDTO bancoDTO);
}
