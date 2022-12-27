package cl.pinolabs.edicontrol.security.repository;

import cl.pinolabs.edicontrol.model.persistence.entity.seguridad.ERole;
import cl.pinolabs.edicontrol.model.persistence.entity.seguridad.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
