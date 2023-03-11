/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea1.service;

import com.tarea1.entity.Categorias;
import com.tarea1.entity.Comentarios;
import com.tarea1.entity.DetalleOrden;
import com.tarea1.entity.Ordenes;
import com.tarea1.entity.Productos;
import com.tarea1.entity.Tipo;
import com.tarea1.entity.Usuarios;

import com.tarea1.repository.CategoriasRepository;
import com.tarea1.repository.ComentariosRepository;
import com.tarea1.repository.DetalleOrdenRepository;
import com.tarea1.repository.OrdenesRepository;
import com.tarea1.repository.ProductosRepository;
import com.tarea1.repository.TipoRepository;
import com.tarea1.repository.UsuariosRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diker Hidalgo
 */
@Service
public class CategoriasService implements ICategoriasService{
    
    @Autowired
    private CategoriasRepository categoriasRepository;
    
    @Override
    public List<Categorias> getAllCategorias() {
        return(List<Categorias>)categoriasRepository.findAll();
    }
   /* 
     @Override
    public void delete(long id) {
        categoriasRepository.deleteById(id);
    }

    @Override
    public Persona getPersonabyId(long id) {
       return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

   

    @Override
    public Persona getPersonaById(Long idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
*/
}
