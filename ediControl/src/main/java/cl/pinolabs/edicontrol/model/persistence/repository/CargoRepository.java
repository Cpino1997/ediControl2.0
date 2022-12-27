package cl.pinolabs.edicontrol.model.persistence.repository;

import cl.pinolabs.edicontrol.model.domain.dto.CargoDTO;
import cl.pinolabs.edicontrol.model.domain.repository.CargoDTORepository;
import cl.pinolabs.edicontrol.model.persistence.crud.CargoCrud;
import cl.pinolabs.edicontrol.model.persistence.mapper.CargoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CargoRepository implements CargoDTORepository {

    private final CargoCrud crud;
    private final CargoMapper mapper;

    public CargoRepository(CargoCrud crud, CargoMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<CargoDTO>> findAll() {
        return Optional.of(mapper.toCargosDTO(crud.findAll()));
    }

    @Override
    public Optional<CargoDTO> findById(int id) {
        return crud.findById(id)
                .map(mapper::toCargoDTO);
    }

    @Override
    public CargoDTO save(CargoDTO cargoDTO) {
        return mapper.toCargoDTO(crud.save(mapper.toCargo(cargoDTO)));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}
