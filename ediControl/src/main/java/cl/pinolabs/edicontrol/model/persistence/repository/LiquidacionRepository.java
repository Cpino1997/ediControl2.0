package cl.pinolabs.edicontrol.model.persistence.repository;

import cl.pinolabs.edicontrol.model.domain.dto.LiquidacionDTO;
import cl.pinolabs.edicontrol.model.domain.repository.LiquidacionDTORepository;
import cl.pinolabs.edicontrol.model.persistence.crud.LiquidacionCrud;
import cl.pinolabs.edicontrol.model.persistence.mapper.LiquidacionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LiquidacionRepository implements LiquidacionDTORepository {

    private final LiquidacionMapper mapper;
    private final LiquidacionCrud crud;

    public LiquidacionRepository(LiquidacionMapper mapper, LiquidacionCrud crud) {
        this.mapper = mapper;
        this.crud = crud;
    }

    @Override
    public Optional<List<LiquidacionDTO>> findAll() {
        return Optional.of(mapper.toLiquidacionesDTO(crud.findAll()));
    }

    @Override
    public Optional<LiquidacionDTO> findById(int id) {
        return crud.findById(id)
                .map(mapper::toLiquidacionDTO);
    }

    @Override
    public LiquidacionDTO save(LiquidacionDTO liquidacionDTO) {
        return mapper.toLiquidacionDTO(crud.save(mapper.toLiquidacion(liquidacionDTO)));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}
