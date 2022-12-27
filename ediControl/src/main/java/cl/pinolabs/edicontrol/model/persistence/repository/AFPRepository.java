package cl.pinolabs.edicontrol.model.persistence.repository;

import cl.pinolabs.edicontrol.model.domain.dto.AfpDTO;
import cl.pinolabs.edicontrol.model.domain.repository.AfpDTORepository;
import cl.pinolabs.edicontrol.model.persistence.crud.AFPCrud;
import cl.pinolabs.edicontrol.model.persistence.mapper.AFPMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AFPRepository implements AfpDTORepository {
    private final AFPMapper mapper;
    private final AFPCrud crud;

    public AFPRepository(AFPMapper mapper, AFPCrud crud) {
        this.mapper = mapper;
        this.crud = crud;
    }

    @Override
    public Optional<List<AfpDTO>> findAll() {
        return Optional.of(mapper.toAFPSDTO(crud.findAll()));
    }

    @Override
    public Optional<AfpDTO> findById(int id) {
        return crud.findById(id)
                .map(mapper::toAFPDTO);
    }

    @Override
    public AfpDTO save(AfpDTO afpdto) {
        return mapper.toAFPDTO(crud.save(mapper.toAFP(afpdto)));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }

    @Override
    public boolean exitsByNombre(String nombre) {
        return crud.existsAfpByNombre(nombre);
    }
}
