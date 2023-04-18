package com.tarea1.service;

import com.tarea1.dto.UsuarioRegistroDTO;
import com.tarea1.entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUsuarioService extends UserDetailsService {
    
    public Usuario guardar(UsuarioRegistroDTO registroDTO);
    
    //obtener un usuario de la base de datos
    public Optional<Usuario> findById(Long id);
    public Usuario findByEmail(String email);
    public Optional<Usuario> findByemail(String email);
    
    //Metodo para traer todos los usuarios
    public List<Usuario> findALL(); 
}
