package cl.pinolabs.edicontrol.model.domain.repository;

import cl.pinolabs.edicontrol.model.domain.dto.CuentaDTO;

import java.util.List;
import java.util.Optional;

public interface CuentaDTORepository {
    Optional<List<CuentaDTO>> findAll();
    Optional<CuentaDTO> findById(int id);
    CuentaDTO save(CuentaDTO cuentaDTO);
    void delete(int id);
}
