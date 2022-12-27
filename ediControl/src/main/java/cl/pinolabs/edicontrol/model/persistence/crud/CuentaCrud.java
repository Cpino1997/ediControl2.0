package cl.pinolabs.edicontrol.model.persistence.crud;

import cl.pinolabs.edicontrol.model.persistence.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaCrud extends JpaRepository<Cuenta, Integer> {
}
