package cl.pinolabs.edicontrol.model.persistence.mapper;

import cl.pinolabs.edicontrol.model.domain.dto.CuentaDTO;
import cl.pinolabs.edicontrol.model.persistence.entity.Cuenta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BancoMapper.class, TipoCuentaMapper.class})
public interface CuentaMapper {
    @Mapping(source = "banco" , target ="bancoDTO")
    @Mapping(source = "tipo" , target ="tipoCuentaDTO")
    CuentaDTO toCuentaDTO(Cuenta cuenta);
    List<CuentaDTO> toCuentasDTO(List<Cuenta> cuentas);
    @InheritInverseConfiguration
    Cuenta toCuenta(CuentaDTO cuentaDTO);
}
