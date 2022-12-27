package cl.pinolabs.edicontrol.model.domain.service;
import cl.pinolabs.edicontrol.model.domain.dto.ContratoDTO;
import cl.pinolabs.edicontrol.model.domain.repository.ContratoDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {
    private final ContratoDTORepository repo;

    public ContratoService(ContratoDTORepository repo) {
        this.repo = repo;
    }
    public Optional<List<ContratoDTO>> findAll(){
        return repo.findAll();
    }
    public Optional<ContratoDTO> findById(int id){
        return repo.findById(id);
    }
    public ContratoDTO save(ContratoDTO contrato){
        return repo.save(contrato);
    }
    public boolean delete(int id){
        return repo.findById(id)
                .map(contrato -> {
                    repo.delete(id);
                    return true;})
                .orElse(false);
    }
}
