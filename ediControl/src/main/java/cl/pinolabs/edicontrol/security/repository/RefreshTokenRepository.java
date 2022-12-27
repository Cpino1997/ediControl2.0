package cl.pinolabs.edicontrol.security.repository;

import cl.pinolabs.edicontrol.model.persistence.entity.seguridad.RefreshToken;
import cl.pinolabs.edicontrol.model.persistence.entity.seguridad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUsuario(Usuario usuario);
}