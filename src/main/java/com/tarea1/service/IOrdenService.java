package com.tarea1.service;

import com.tarea1.entity.Orden;
import com.tarea1.entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface IOrdenService {
    
    List<Orden> findAll();
    Optional<Orden> findById(Long id);
    //metodo para retornar una orden
    Orden save(Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUsuario(Usuario usuario);
    
}
