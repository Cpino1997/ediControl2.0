package cl.pinolabs.edicontrol.security.service;

import cl.pinolabs.edicontrol.model.persistence.entity.seguridad.Usuario;
import cl.pinolabs.edicontrol.security.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.*;

import jakarta.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsuarioRepository userRepository;

    public UserDetailsServiceImpl(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario: " + username + " no ha sido encontrado en la base de datos"));

        return UserDetailsImpl.build(user);
    }

}