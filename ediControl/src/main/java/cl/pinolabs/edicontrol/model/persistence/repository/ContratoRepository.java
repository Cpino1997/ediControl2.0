package cl.pinolabs.edicontrol.model.persistence.repository;

import cl.pinolabs.edicontrol.model.domain.dto.ContratoDTO;
import cl.pinolabs.edicontrol.model.domain.repository.ContratoDTORepository;
import cl.pinolabs.edicontrol.model.persistence.crud.ContratoCrud;
import cl.pinolabs.edicontrol.model.persistence.mapper.ContratoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ContratoRepository implements ContratoDTORepository {
    private final ContratoCrud crud;
    private final ContratoMapper mapper;

    public ContratoRepository(ContratoCrud crud, ContratoMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<ContratoDTO>> findAll() {
        return Optional.of(mapper.toContratosDTO(crud.findAll()));
    }

    @Override
    public Optional<ContratoDTO> findById(int id) {
        return crud.findById(id)
                .map(mapper::toContratoDTO);
    }

    @Override
    public ContratoDTO save(ContratoDTO contrato) {
        return mapper.toContratoDTO(crud.save(mapper.toContrato(contrato)));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}
