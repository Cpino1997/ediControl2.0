package cl.pinolabs.edicontrol.model.domain.repository;

import cl.pinolabs.edicontrol.model.domain.dto.RegionDTO;

import java.util.List;
import java.util.Optional;

public interface RegionDTORepository {
    Optional<List<RegionDTO>> findAll();
    Optional<RegionDTO> findById(int id);
    RegionDTO save(RegionDTO regionDTO);
    void delete(int id);
}
