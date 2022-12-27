package cl.pinolabs.edicontrol.model.persistence.crud;

import cl.pinolabs.edicontrol.model.persistence.entity.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoCrud extends JpaRepository<Banco, Integer> {
}
