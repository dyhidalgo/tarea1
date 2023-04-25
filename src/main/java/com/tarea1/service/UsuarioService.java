package com.tarea1.service;

import com.tarea1.dto.UsuarioRegistroDTO;
import com.tarea1.entity.Rol;
import com.tarea1.entity.Usuario;
import com.tarea1.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private HttpSession session;
    
    private final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
    
        Usuario usuario = new Usuario(registroDTO.getNombre(), 
                                      registroDTO.getApellido(), 
                                      registroDTO.getEmail(), 
                                      passwordEncoder.encode(registroDTO.getPassword()), 
                                    Arrays.asList(new Rol("ROL_USER")));
        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       log.info("Este es el username");
        Optional<Usuario> optionalUser = usuarioRepository.findByemail(username);
        if(optionalUser.isPresent()){
            log.info("Este es el id del usuario: {}", optionalUser.get().getId());
            session.setAttribute("id", optionalUser.get().getId());

            Usuario usuario = optionalUser.get();
            return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
        }
      throw new UsernameNotFoundException("Usuario o password invalidos");
    }
    
    //lo mapea a SimpleGrantedAuthority y se obtiene el nombre de cada rol
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Optional<Usuario> findByemail(String email) {
        return usuarioRepository.findByemail(email);
    }

    @Override
    public List<Usuario> findALL() {
        return usuarioRepository.findAll();
    }

    


}
