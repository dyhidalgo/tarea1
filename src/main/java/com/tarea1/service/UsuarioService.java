package com.tarea1.service;

import com.tarea1.dto.UsuarioRegistroDTO;
import com.tarea1.entity.Rol;
import com.tarea1.entity.Usuario;
import com.tarea1.repository.UsuarioRepository;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
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
        Usuario usuario = usuarioRepository.findByEmail(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario o password invalidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }
    
    //lo mapea a SimpleGrantedAuthority y se obtiene el nombre de cada rol
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
}
