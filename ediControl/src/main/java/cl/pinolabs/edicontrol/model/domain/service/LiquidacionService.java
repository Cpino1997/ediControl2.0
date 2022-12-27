package cl.pinolabs.edicontrol.model.domain.service;

import cl.pinolabs.edicontrol.model.domain.dto.LiquidacionDTO;
import cl.pinolabs.edicontrol.model.domain.repository.LiquidacionDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiquidacionService {
    private final LiquidacionDTORepository repo;
    public LiquidacionService(LiquidacionDTORepository repo) {
        this.repo = repo;
    }
    public Optional<List<LiquidacionDTO>> findAll(){
        return repo.findAll();
    }
    public Optional<LiquidacionDTO> findById(int id){
        return repo.findById(id);
    }
    public LiquidacionDTO save(LiquidacionDTO liquidacionDTO){
        return repo.save(liquidacionDTO);
    }
    public boolean delete(int id){
        return repo.findById(id)
                .map(liquidacionDTO -> {
                    repo.delete(id);
                    return true;})
                .orElse(false);
    }
}
