/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tarea1.service;

import com.tarea1.entity.Productos;
import java.util.List;

/**
 *
 * @author Diker Hidalgo
 */
public interface IProductosService {

    public List<Productos> listProductos();

    public Productos getProductosById(long id);

    public void saveProductos(Productos productos);

    public void delete(long id);
}
