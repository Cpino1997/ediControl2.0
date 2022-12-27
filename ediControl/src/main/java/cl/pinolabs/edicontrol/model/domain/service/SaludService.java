package cl.pinolabs.edicontrol.model.domain.service;

import cl.pinolabs.edicontrol.model.domain.dto.SaludDTO;
import cl.pinolabs.edicontrol.model.domain.repository.SaludDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaludService {
    private final SaludDTORepository repo;

    public SaludService(SaludDTORepository repo) {
        this.repo = repo;
    }

    public Optional<List<SaludDTO>> findAll(){
        return repo.findAll();
    }
    public Optional<SaludDTO> findById(int id){
        return repo.findById(id);
    }
    public SaludDTO save(SaludDTO saludDTO){
        return repo.save(saludDTO);
    }
    public boolean delete(int id){
        return repo.findById(id)
                .map(saludDTO -> {
                    repo.delete(id);
                    return true;})
                .orElse(false);
    }
    public boolean exitsByNombre(String nombre){
        return repo.findAll()
                .map(saludDTO ->{
                    repo.exitsByNombre(nombre);
                    return true;})
                .orElse(false);
    }
}
