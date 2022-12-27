package cl.pinolabs.edicontrol.model.persistence.crud;

import cl.pinolabs.edicontrol.model.persistence.entity.Afp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AFPCrud extends JpaRepository<Afp,Integer> {
    Boolean existsAfpByNombre(String username);
}
