package cl.pinolabs.edicontrol.model.domain.service;

import cl.pinolabs.edicontrol.model.domain.dto.RegionDTO;
import cl.pinolabs.edicontrol.model.domain.repository.RegionDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RegionService {
    private final RegionDTORepository repo;
    public RegionService(RegionDTORepository repo) {
        this.repo = repo;
    }

    public Optional<List<RegionDTO>> findAll(){
        return repo.findAll();
    }
    public Optional<RegionDTO> findById(int id){
        return repo.findById(id);
    }
    public RegionDTO save(RegionDTO regionDTO){
        return repo.save(regionDTO);
    }
    public boolean delete(int id){
        return repo.findById(id)
                .map(regionDTO -> {
                    repo.delete(id);
                    return true;})
                .orElse(false);
    }
}
