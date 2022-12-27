package cl.pinolabs.edicontrol.model.domain.repository;

import cl.pinolabs.edicontrol.model.domain.dto.LiquidacionDTO;

import java.util.List;
import java.util.Optional;

public interface LiquidacionDTORepository {
    Optional<List<LiquidacionDTO>> findAll();
    Optional<LiquidacionDTO> findById(int id);
    LiquidacionDTO save(LiquidacionDTO liquidacionDTO);
    void delete(int id);
}
