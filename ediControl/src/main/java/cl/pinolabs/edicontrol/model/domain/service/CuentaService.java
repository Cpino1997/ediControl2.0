package cl.pinolabs.edicontrol.model.domain.service;

import cl.pinolabs.edicontrol.model.domain.dto.CuentaDTO;
import cl.pinolabs.edicontrol.model.domain.repository.CuentaDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    private final CuentaDTORepository repo;
    public CuentaService(CuentaDTORepository repo) {
        this.repo = repo;
    }
    public Optional<List<CuentaDTO>> findAll(){
        return repo.findAll();
    }
    public Optional<CuentaDTO> findById(int id){
        return repo.findById(id);
    }
    public CuentaDTO save(CuentaDTO cuentaDTO){
        return repo.save(cuentaDTO);
    }
    public boolean delete(int id){
        return repo.findById(id)
                .map(cuentaDTO -> {
                    repo.delete(id);
                    return true;})
                .orElse(false);
    }
}
