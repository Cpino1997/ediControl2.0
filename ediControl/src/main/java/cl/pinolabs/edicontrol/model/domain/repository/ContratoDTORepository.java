package cl.pinolabs.edicontrol.model.domain.repository;

import cl.pinolabs.edicontrol.model.domain.dto.AfpDTO;
import cl.pinolabs.edicontrol.model.domain.dto.ContratoDTO;

import java.util.List;
import java.util.Optional;

public interface ContratoDTORepository {
    Optional<List<ContratoDTO>> findAll();
    Optional<ContratoDTO> findById(int id);
    ContratoDTO save(ContratoDTO contrato);
    void delete(int id);
}
