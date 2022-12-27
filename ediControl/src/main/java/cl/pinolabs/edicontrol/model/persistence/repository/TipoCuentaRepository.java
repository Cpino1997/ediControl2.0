package cl.pinolabs.edicontrol.model.persistence.repository;

import cl.pinolabs.edicontrol.model.domain.dto.TipoCuentaDTO;
import cl.pinolabs.edicontrol.model.domain.repository.TipoCuentaDTORepository;
import cl.pinolabs.edicontrol.model.persistence.crud.TipoCuentaCrud;
import cl.pinolabs.edicontrol.model.persistence.mapper.TipoCuentaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipoCuentaRepository implements TipoCuentaDTORepository {
    private final TipoCuentaMapper mapper;
    private final TipoCuentaCrud crud;

    public TipoCuentaRepository(TipoCuentaMapper mapper, TipoCuentaCrud crud) {
        this.mapper = mapper;
        this.crud = crud;
    }

    @Override
    public Optional<List<TipoCuentaDTO>> findAll() {
        return Optional.of(mapper.toTiposDTO(crud.findAll()));
    }

    @Override
    public Optional<TipoCuentaDTO> findById(int id) {
        return crud.findById(id)
                .map(mapper::toTipoDTO);
    }

    @Override
    public TipoCuentaDTO save(TipoCuentaDTO tipoCuentaDTO) {
        return mapper.toTipoDTO(crud.save(mapper.toTipo(tipoCuentaDTO)));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}
