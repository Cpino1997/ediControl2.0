package cl.pinolabs.edicontrol.model.persistence.mapper;

import cl.pinolabs.edicontrol.model.domain.dto.CargoDTO;
import cl.pinolabs.edicontrol.model.persistence.entity.Cargo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CargoMapper {
    @Mapping(target = "id",source = "id")
    @Mapping(target = "nombre",source = "nombre")
    @Mapping(target = "sueldo",source = "sueldo")

    CargoDTO toCargoDTO(Cargo cargos);
    List<CargoDTO> toCargosDTO(List<Cargo> cargos);
    @InheritInverseConfiguration
    Cargo toCargo(CargoDTO cargoDTO);
}

