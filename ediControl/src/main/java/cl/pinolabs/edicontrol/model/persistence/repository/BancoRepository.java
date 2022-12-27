package cl.pinolabs.edicontrol.model.persistence.repository;

import cl.pinolabs.edicontrol.model.domain.dto.BancoDTO;
import cl.pinolabs.edicontrol.model.domain.repository.BancoDTORepository;
import cl.pinolabs.edicontrol.model.persistence.crud.BancoCrud;
import cl.pinolabs.edicontrol.model.persistence.mapper.BancoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BancoRepository implements BancoDTORepository {
    private final BancoMapper mapper;
    private final BancoCrud crud;

    public BancoRepository(BancoMapper mapper, BancoCrud crud) {
        this.mapper = mapper;
        this.crud = crud;
    }

    @Override
    public Optional<List<BancoDTO>> findAll() {
        return Optional.of(mapper.toBancosDTO(crud.findAll()));
    }

    @Override
    public Optional<BancoDTO> findById(int id) {
        return crud.findById(id)
                .map(mapper::toBancoDTO);
    }

    @Override
    public BancoDTO save(BancoDTO bancoDTO) {
        return mapper.toBancoDTO(crud.save(mapper.toBanco(bancoDTO)));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}
