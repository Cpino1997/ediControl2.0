package cl.pinolabs.edicontrol.model.domain.repository;

import cl.pinolabs.edicontrol.model.domain.dto.AfpDTO;

import java.util.List;
import java.util.Optional;

public interface AfpDTORepository {
    Optional<List<AfpDTO>> findAll();
    Optional<AfpDTO> findById(int id);
    AfpDTO save(AfpDTO afpdto);
    void delete(int id);
    boolean exitsByNombre(String nombre);
}
