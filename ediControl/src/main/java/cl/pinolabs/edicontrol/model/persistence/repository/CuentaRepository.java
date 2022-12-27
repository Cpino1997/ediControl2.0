package cl.pinolabs.edicontrol.model.persistence.repository;

import cl.pinolabs.edicontrol.model.domain.dto.CuentaDTO;
import cl.pinolabs.edicontrol.model.domain.repository.CuentaDTORepository;
import cl.pinolabs.edicontrol.model.persistence.crud.CuentaCrud;
import cl.pinolabs.edicontrol.model.persistence.mapper.CuentaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CuentaRepository implements CuentaDTORepository {
    private final CuentaMapper mapper;
    private final CuentaCrud crud;

    public CuentaRepository(CuentaMapper mapper, CuentaCrud crud) {
        this.mapper = mapper;
        this.crud = crud;
    }

    @Override
    public Optional<List<CuentaDTO>> findAll() {
        return Optional.of(mapper.toCuentasDTO(crud.findAll()));
    }

    @Override
    public Optional<CuentaDTO> findById(int id) {
        return crud.findById(id)
                .map(mapper::toCuentaDTO);
    }

    @Override
    public CuentaDTO save(CuentaDTO cuentaDTO) {
        return mapper.toCuentaDTO(crud.save(mapper.toCuenta(cuentaDTO)));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}
