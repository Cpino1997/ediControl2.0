package cl.pinolabs.edicontrol.model.persistence.repository;

import cl.pinolabs.edicontrol.model.domain.dto.ComunaDTO;
import cl.pinolabs.edicontrol.model.domain.repository.ComunaDTORepository;
import cl.pinolabs.edicontrol.model.persistence.crud.ComunaCrud;
import cl.pinolabs.edicontrol.model.persistence.mapper.ComunaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComunaRepository implements ComunaDTORepository {
    private final ComunaCrud crud;
    private final ComunaMapper mapper;

    public ComunaRepository(ComunaCrud crud, ComunaMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<ComunaDTO>> findAll() {
        return Optional.of(mapper.toComunasDTO(crud.findAll()));
    }
    @Override
    public Optional<ComunaDTO> findById(int id) {
        return crud.findById(id)
                .map(mapper::toComunaDTO);
    }
    @Override
    public Optional<List<ComunaDTO>> findByIdRegion(int id) {
        return crud.findByIdRegion(id)
                .map(mapper::toComunasDTO);
    }
    @Override
    public ComunaDTO save(ComunaDTO comunaDTO) {
        return mapper.toComunaDTO(crud.save(mapper.toComuna(comunaDTO)));
    }
    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}
