package cl.pinolabs.edicontrol.model.persistence.crud;

import cl.pinolabs.edicontrol.model.persistence.entity.Salud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaludCrud extends JpaRepository<Salud, Integer> {
    boolean existsByNombre(String nombre);

}
