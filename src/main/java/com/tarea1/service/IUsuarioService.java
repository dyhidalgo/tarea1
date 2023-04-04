package com.tarea1.service;

import com.tarea1.dto.UsuarioRegistroDTO;
import com.tarea1.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUsuarioService extends UserDetailsService {
    
    public Usuario guardar(UsuarioRegistroDTO registroDTO);
}
