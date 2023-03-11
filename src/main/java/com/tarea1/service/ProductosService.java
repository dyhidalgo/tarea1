/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea1.service;

import com.tarea1.entity.Productos;
import com.tarea1.repository.ProductosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diker Hidalgo
 */
@Service
public class ProductosService implements IProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Productos> listProductos() {
        return (List<Productos>) productosRepository.findAll();
    }
}




