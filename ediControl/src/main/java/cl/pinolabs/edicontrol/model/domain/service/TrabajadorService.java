package cl.pinolabs.edicontrol.model.domain.service;

import cl.pinolabs.edicontrol.model.domain.dto.TrabajadorDTO;
import cl.pinolabs.edicontrol.model.domain.repository.TrabajadorDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TrabajadorService {
    private final TrabajadorDTORepository repo;
    public TrabajadorService(TrabajadorDTORepository repo) {
        this.repo = repo;
    }
    public Optional<List<TrabajadorDTO>> findAll(){
        return repo.findAll();
    }
    public Optional<TrabajadorDTO> findById(int id){
        return repo.findById(id);
    }

    public TrabajadorDTO save(TrabajadorDTO trabajadorDTO){
        return repo.save(trabajadorDTO);
    }
    public boolean delete(int id){
        return repo.findById(id)
                .map(trabajadorDTO -> {
                    repo.delete(id);
                    return true;})
                .orElse(false);
    }
}
