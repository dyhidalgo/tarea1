package com.tarea1.repository;

import com.tarea1.entity.Orden;
import com.tarea1.entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
    //metodo para traer todas las ordenes pero por usuario\
    List<Orden> findByUsuario(Usuario usuario);
}
