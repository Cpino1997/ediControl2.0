package cl.pinolabs.edicontrol.model.persistence.crud;

import cl.pinolabs.edicontrol.model.persistence.entity.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComunaCrud extends JpaRepository<Comuna,Integer> {
    Optional<List<Comuna>> findByIdRegion(Integer id);
}
