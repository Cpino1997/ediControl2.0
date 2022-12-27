package cl.pinolabs.edicontrol.model.persistence.mapper;

import cl.pinolabs.edicontrol.model.domain.dto.TipoCuentaDTO;
import cl.pinolabs.edicontrol.model.persistence.entity.TipoCuenta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoCuentaMapper {
    TipoCuentaDTO toTipoDTO(TipoCuenta tipo);
    List<TipoCuentaDTO> toTiposDTO(List<TipoCuenta> tipos);
    @InheritInverseConfiguration
    TipoCuenta toTipo(TipoCuentaDTO tipoCuentaDTO);
}
