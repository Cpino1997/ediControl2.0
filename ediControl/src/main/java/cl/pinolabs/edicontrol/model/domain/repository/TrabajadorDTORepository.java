package cl.pinolabs.edicontrol.model.domain.repository;

import cl.pinolabs.edicontrol.model.domain.dto.TrabajadorDTO;

import java.util.List;
import java.util.Optional;

public interface TrabajadorDTORepository {
    Optional<List<TrabajadorDTO>> findAll();
    Optional<TrabajadorDTO> findById(int id);
    TrabajadorDTO save(TrabajadorDTO trabajadorDTO);
    void delete(int id);
}
