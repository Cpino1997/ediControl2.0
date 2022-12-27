package cl.pinolabs.edicontrol.model.persistence.repository;

import cl.pinolabs.edicontrol.model.domain.dto.SaludDTO;
import cl.pinolabs.edicontrol.model.domain.repository.SaludDTORepository;
import cl.pinolabs.edicontrol.model.persistence.crud.SaludCrud;
import cl.pinolabs.edicontrol.model.persistence.mapper.SaludMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SaludRepository implements SaludDTORepository {
    private final SaludMapper mapper;
    private final SaludCrud crud;

    public SaludRepository(SaludMapper mapper, SaludCrud crud) {
        this.mapper = mapper;
        this.crud = crud;
    }

    @Override
    public Optional<List<SaludDTO>> findAll() {
        return Optional.of(mapper.toSaludDTOs(crud.findAll()));
    }

    @Override
    public Optional<SaludDTO> findById(int id) {
        return crud.findById(id)
                .map(mapper::toSaludDTO);
    }

    @Override
    public SaludDTO save(SaludDTO saludDTO) {
        return mapper.toSaludDTO(crud.save(mapper.toSalud(saludDTO)));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }

    @Override
    public void exitsByNombre(String nombre) {
        crud.existsByNombre(nombre);
    }
}
