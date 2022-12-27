package cl.pinolabs.edicontrol.model.domain.repository;

import cl.pinolabs.edicontrol.model.domain.dto.ComunaDTO;

import java.util.List;
import java.util.Optional;

public interface ComunaDTORepository {
    Optional<List<ComunaDTO>> findAll();
    Optional<ComunaDTO> findById(int id);
    Optional<List<ComunaDTO>> findByIdRegion(int id);
    ComunaDTO save(ComunaDTO comunaDTO);
    void delete(int id);
}
