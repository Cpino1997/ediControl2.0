package cl.pinolabs.edicontrol.model.persistence.crud;

import cl.pinolabs.edicontrol.model.persistence.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionCrud extends JpaRepository<Region,Integer> {
}
