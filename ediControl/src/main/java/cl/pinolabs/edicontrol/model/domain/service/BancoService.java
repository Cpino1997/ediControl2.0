package cl.pinolabs.edicontrol.model.domain.service;

import cl.pinolabs.edicontrol.model.domain.dto.BancoDTO;
import cl.pinolabs.edicontrol.model.domain.repository.BancoDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoService {
    private final BancoDTORepository repo;

    public BancoService(BancoDTORepository repo) {
        this.repo = repo;
    }
    public Optional<List<BancoDTO>> findAll(){
        return repo.findAll();
    }
    public Optional<BancoDTO> findById(int id){
        return repo.findById(id);
    }
    public BancoDTO save(BancoDTO bancoDTO){
        return repo.save(bancoDTO);
    }
    public boolean delete(int id){
        return repo.findById(id)
                .map(saludDTO -> {
                    repo.delete(id);
                    return true;})
                .orElse(false);
    }

}
