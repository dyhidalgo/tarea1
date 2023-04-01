package com.tarea1.repository;

import com.tarea1.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public Usuario findByUsername(String username);
}
