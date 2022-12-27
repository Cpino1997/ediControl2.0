package cl.pinolabs.edicontrol.model.persistence.crud;

import cl.pinolabs.edicontrol.model.persistence.entity.Liquidacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiquidacionCrud extends JpaRepository<Liquidacion,Integer> {
}
