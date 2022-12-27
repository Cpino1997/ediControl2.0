package cl.pinolabs.edicontrol.model.domain.service;

import cl.pinolabs.edicontrol.model.domain.dto.TipoCuentaDTO;
import cl.pinolabs.edicontrol.model.domain.repository.TipoCuentaDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoCuentaService {
    private final TipoCuentaDTORepository repo;
    public TipoCuentaService(TipoCuentaDTORepository repo) {
        this.repo = repo;
    }
    public Optional<List<TipoCuentaDTO>> findAll(){
        return repo.findAll();
    }
    public Optional<TipoCuentaDTO> findById(int id){
        return repo.findById(id);
    }
    public TipoCuentaDTO save(TipoCuentaDTO tipoCuentaDTO){
        return repo.save(tipoCuentaDTO);
    }
    public boolean delete(int id){
        return repo.findById(id)
                .map(tipoCuentaDTO -> {
                    repo.delete(id);
                    return true;})
                .orElse(false);
    }

}
