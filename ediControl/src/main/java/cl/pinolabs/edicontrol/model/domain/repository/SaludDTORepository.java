package cl.pinolabs.edicontrol.model.domain.repository;

import cl.pinolabs.edicontrol.model.domain.dto.SaludDTO;

import java.util.List;
import java.util.Optional;

public interface SaludDTORepository {
    Optional<List<SaludDTO>> findAll();
    Optional<SaludDTO> findById(int id);
    SaludDTO save(SaludDTO saludDTO);
    void delete(int id);
    void exitsByNombre(String nombre);
}
