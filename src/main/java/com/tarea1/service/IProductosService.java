
package com.tarea1.service;

import com.tarea1.entity.Productos;
import java.util.List;

public interface IProductosService {

    public List<Productos> listProductos();

    public Productos getProductosById(long id);

    public void saveProductos(Productos productos);

    public void delete(long id);

    public List<Productos> getByKeyword(String Keyword);

    public List<Productos> getAllProductos();
}
