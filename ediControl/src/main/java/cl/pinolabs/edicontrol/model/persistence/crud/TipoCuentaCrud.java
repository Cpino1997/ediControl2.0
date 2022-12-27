package cl.pinolabs.edicontrol.model.persistence.crud;

import cl.pinolabs.edicontrol.model.persistence.entity.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCuentaCrud extends JpaRepository<TipoCuenta,Integer> {
}
