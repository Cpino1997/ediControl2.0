package cl.pinolabs.edicontrol.model.domain.service;

import cl.pinolabs.edicontrol.model.domain.dto.AfpDTO;
import cl.pinolabs.edicontrol.model.domain.repository.AfpDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfpService {
    private final AfpDTORepository repo;

    public AfpService(AfpDTORepository repo) {
        this.repo = repo;
    }

    public Optional<List<AfpDTO>> findAll(){
        return repo.findAll();
    }
    public Optional<AfpDTO> findById(int id){
        return repo.findById(id);
    }
    public AfpDTO save(AfpDTO afpDTO){
        return repo.save(afpDTO);
    }
    public boolean delete(int id){
        return repo.findById(id)
                .map(afpdto -> {
                    repo.delete(id);
                    return true;})
                .orElse(false);
    }
    public boolean exitsByNombre(String nombre){
        boolean existe = repo.exitsByNombre(nombre);
        if(existe){
            return true;
        }
        return false;
    }
}
