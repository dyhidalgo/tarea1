
package com.tarea1.repository;

import com.tarea1.entity.Carrito;
import com.tarea1.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    public Optional<Carrito> findByUsuario(Usuario usuario);

}
