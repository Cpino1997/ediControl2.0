package cl.pinolabs.edicontrol.model.domain.repository;

import cl.pinolabs.edicontrol.model.domain.dto.TipoCuentaDTO;

import java.util.List;
import java.util.Optional;

public interface TipoCuentaDTORepository {
    Optional<List<TipoCuentaDTO>> findAll();
    Optional<TipoCuentaDTO> findById(int id);
    TipoCuentaDTO save(TipoCuentaDTO tipoCuentaDTO);
    void delete(int id);
}
