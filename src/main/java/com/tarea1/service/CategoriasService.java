/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea1.service;

import com.tarea1.entity.Categorias;

import com.tarea1.repository.CategoriasRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diker Hidalgo
 */
@Service
public class CategoriasService implements ICategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Override
    public List<Categorias> getAllCategorias() {
        return (List<Categorias>) categoriasRepository.findAll();
    }

}