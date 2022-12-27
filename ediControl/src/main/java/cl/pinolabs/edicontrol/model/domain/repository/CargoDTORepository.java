package cl.pinolabs.edicontrol.model.domain.repository;

import cl.pinolabs.edicontrol.model.domain.dto.CargoDTO;

import java.util.List;
import java.util.Optional;

public interface CargoDTORepository {
    Optional<List<CargoDTO>> findAll();
    Optional<CargoDTO> findById(int id);
    CargoDTO save(CargoDTO cargoDTO);
    void delete(int id);
}
