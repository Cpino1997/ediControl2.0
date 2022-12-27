package cl.pinolabs.edicontrol.model.persistence.crud;

import cl.pinolabs.edicontrol.model.persistence.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorCrud extends JpaRepository<Trabajador,Integer> {
}
