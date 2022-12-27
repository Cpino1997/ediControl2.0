package cl.pinolabs.edicontrol.model.persistence.repository;

import cl.pinolabs.edicontrol.model.domain.dto.RegionDTO;
import cl.pinolabs.edicontrol.model.domain.repository.RegionDTORepository;
import cl.pinolabs.edicontrol.model.persistence.crud.RegionCrud;
import cl.pinolabs.edicontrol.model.persistence.mapper.RegionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RegionRepository implements RegionDTORepository {
    private final RegionCrud crud;
    private final RegionMapper mapper;

    public RegionRepository(RegionCrud crud, RegionMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<RegionDTO>> findAll() {
        return Optional.of(mapper.toRegionesDTO(crud.findAll()));
    }

    @Override
    public Optional<RegionDTO> findById(int id) {
        return crud.findById(id)
                .map(mapper::toRegionDTO);
    }


    @Override
    public RegionDTO save(RegionDTO regionDTO) {
        return mapper.toRegionDTO(crud.save(mapper.toRegion(regionDTO)));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}
