
package com.tarea1.controller;

import com.tarea1.entity.Carrito;
import com.tarea1.entity.ItemCarrito;
import com.tarea1.entity.Productos;
import com.tarea1.entity.Usuario;
import com.tarea1.service.CarritoService;
import com.tarea1.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Carrito")
public class CarritoController {

    private final CarritoService carritoService;
    private final ProductosService productosService;

    @Autowired
    public CarritoController(CarritoService carritoService, ProductosService productosService) {
        this.carritoService = carritoService;
        this.productosService = productosService;
    }

    @GetMapping
    public ResponseEntity<?> getCarritoPorUsuario(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Carrito carrito = carritoService.getCarritoPorUsuario(usuario);
        return ResponseEntity.ok(carrito);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarItemAlCarrito(@RequestBody ItemCarritoRequest itemCarritoRequest, Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        //Productos productos = productosService.getProductosPorId(itemCarritoRequest.getIdProductos());
        ItemCarrito itemCarrito = new ItemCarrito();
        //itemCarrito.setProductos(productos);
        //itemCarrito.setCantidad(itemCarritoRequest.getCantidad
        return null;
    }
}

