package com.tarea1.service;

import com.tarea1.entity.Productos;
import com.tarea1.repository.ProductosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService implements IProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Productos> listProductos() {
        return (List<Productos>) productosRepository.findAll();
    }

    @Override
    public Productos getProductosById(long id) {
        return productosRepository.findById(id).orElse(null);

    }

    @Override
    public void saveProductos(Productos productos) {
        productosRepository.save(productos);
    }

    @Override
    public void delete(long id) {
        productosRepository.deleteById(id);
    }

    @Override
    public List<Productos> getByKeyword(String Keyword) {
        return productosRepository.findByKeyword(Keyword);
    }

    @Override
    public List<Productos> getAllProductos() {
        return (List<Productos>) productosRepository.findAll();
    }
}
