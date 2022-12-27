package cl.pinolabs.edicontrol.model.domain.repository;

import cl.pinolabs.edicontrol.model.domain.dto.BancoDTO;

import java.util.List;
import java.util.Optional;

public interface BancoDTORepository {
    Optional<List<BancoDTO>> findAll();
    Optional<BancoDTO> findById(int id);
    BancoDTO save(BancoDTO bancoDTO);
    void delete(int id);
}
