package cl.pinolabs.edicontrol.model.persistence.repository;

import cl.pinolabs.edicontrol.model.domain.dto.TrabajadorDTO;
import cl.pinolabs.edicontrol.model.domain.repository.TrabajadorDTORepository;
import cl.pinolabs.edicontrol.model.persistence.crud.TrabajadorCrud;
import cl.pinolabs.edicontrol.model.persistence.mapper.TrabajadorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TrabajadorRepository implements TrabajadorDTORepository {
    private final TrabajadorCrud crud;
    private final TrabajadorMapper mapper;

    public TrabajadorRepository(TrabajadorCrud crud, TrabajadorMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<TrabajadorDTO>> findAll() {
        return Optional.of(mapper.toTrabajadoresDTO(crud.findAll()));
    }


    @Override
    public Optional<TrabajadorDTO> findById(int id) {
        return crud.findById(id)
                .map(mapper::toTrabajadorDTO);
    }

    @Override
    public TrabajadorDTO save(TrabajadorDTO trabajadorDTO) {
        return mapper.toTrabajadorDTO(crud.save(mapper.toTrabajador(trabajadorDTO)));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}
