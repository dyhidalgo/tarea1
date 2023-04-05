
package com.tarea1.service;

import com.tarea1.entity.Carrito;
import com.tarea1.entity.ItemCarrito;
import com.tarea1.entity.Usuario;
import com.tarea1.repository.CarritoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarritoService {

    private final CarritoRepository carritoRepository;

    @Autowired
    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    public Carrito getCarritoPorUsuario(Usuario usuario) {
        Optional<Carrito> optionalCarrito = carritoRepository.findByUsuario(usuario);
        return optionalCarrito.orElseGet(() -> crearCarrito(usuario));
    }

    public void agregarItemAlCarrito(ItemCarrito itemCarrito, Usuario usuario) {
        Carrito carrito = getCarritoPorUsuario(usuario);
        //carrito.getItemsCarrito().add(itemCarrito);
        carritoRepository.save(carrito);
    }

    private Carrito crearCarrito(Usuario usuario) {
        Carrito carrito = new Carrito();
        carrito.setUsuario(usuario);
        return carritoRepository.save(carrito);
    }
}
