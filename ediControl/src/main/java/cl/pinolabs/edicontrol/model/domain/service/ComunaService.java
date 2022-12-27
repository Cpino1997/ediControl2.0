package cl.pinolabs.edicontrol.model.domain.service;

import cl.pinolabs.edicontrol.model.domain.dto.ComunaDTO;
import cl.pinolabs.edicontrol.model.domain.repository.ComunaDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ComunaService {
    private final ComunaDTORepository repo;
    public ComunaService(ComunaDTORepository repo) {
        this.repo = repo;
    }

    public Optional<List<ComunaDTO>> findAll(){
        return repo.findAll();
    }
    public Optional<ComunaDTO> findById(int id){
        return repo.findById(id);
    }
    public Optional<List<ComunaDTO>> findByIdRegion(int id){
        return repo.findByIdRegion(id);
    }
    public ComunaDTO save(ComunaDTO comunaDTO){
        return repo.save(comunaDTO);
    }
    public boolean delete(int id){
        return repo.findById(id)
                .map(comunaDTO -> {
                    repo.delete(id);
                    return true;})
                .orElse(false);
    }
}
