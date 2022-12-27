package cl.pinolabs.edicontrol.model.persistence.crud;

import cl.pinolabs.edicontrol.model.persistence.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoCrud extends JpaRepository<Cargo,Integer> {
}
