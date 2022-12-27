package cl.pinolabs.edicontrol.model.persistence.crud;

import cl.pinolabs.edicontrol.model.persistence.entity.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoCrud extends JpaRepository<Contrato, Integer> {
}
