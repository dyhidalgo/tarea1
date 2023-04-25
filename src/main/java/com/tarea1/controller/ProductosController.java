/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea1.controller;

import com.mysql.cj.conf.PropertyKey;
import com.tarea1.entity.Categorias;
import com.tarea1.entity.DetalleOrden;
import com.tarea1.entity.Opinion;
import com.tarea1.entity.Orden;
import com.tarea1.entity.Productos;
import com.tarea1.entity.Usuario;

import com.tarea1.service.ICategoriasService;
import com.tarea1.service.IDetalleOrdenService;
import com.tarea1.service.IOpinionService;
import com.tarea1.service.IOrdenService;
import com.tarea1.service.IProductosService;
import com.tarea1.service.IUsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductosController {

    private final Logger log = LoggerFactory.getLogger(ProductosController.class);

    @Autowired
    private ICategoriasService categoriasService;

    @Autowired
    private IProductosService productosService;

    @Autowired
    private IOpinionService opinionService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IOrdenService ordenService;

    @Autowired
    private IDetalleOrdenService detalleOrdenService;

    //Para almacenar los detalles de la orden
    List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    // datos de la orden
    Orden orden = new Orden();

    @GetMapping("/productos")
    public String index(Model model) {
        List<Productos> listaProductos = productosService.listProductos();
        model.addAttribute("titulo", "Tabla Productos");
        model.addAttribute("productos", listaProductos);
        return "productos";
    }

    @GetMapping("/productosN")
    public String crearProductos(Model model) {
        List<Categorias> listaCategorias = categoriasService.getAllCategorias();
        model.addAttribute("productos", new Productos());
        model.addAttribute("categorias", listaCategorias);
        return "crear";
    }

    @GetMapping("/delete/{id}")
    public String eliminarProductos(@PathVariable("id") Long idProducto) {
        productosService.delete(idProducto);
        return "redirect:/productos";
    }

    @PostMapping("/save")
    public String guardarProductos(@ModelAttribute Productos productos) {
        productosService.saveProductos(productos);
        return "redirect:/productos";
    }

    @GetMapping("/editProductos/{id}")
    public String editarProductos(@PathVariable("id") Long idProductos, Model model) {
        Productos productos = productosService.getProductosById(idProductos);
        List<Categorias> listaCategorias = categoriasService.getAllCategorias();
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", listaCategorias);
        return "crear";
    }

    @GetMapping("/prueba")
    public String getProducts(Model model) {
        List<Productos> listaProductos = productosService.listProductos();
        model.addAttribute("productos", listaProductos);
        return "prueba";
    }

    //Principal
    @GetMapping("/principal")
    public String getProductsPrincipal(Model model) {
        List<Productos> listaProductos = productosService.listProductos();
        model.addAttribute("productos", listaProductos);
        return "principal";
    }

    //Ofertas Hombre
    @GetMapping("/ofertasHombre")
    public String getProductsOfertasH(Model model) {
        List<Productos> listaProductos = productosService.listProductos();
        model.addAttribute("productos", listaProductos);
        return "ofertasHombre";
    }

    //Ofertas Mujer
    @GetMapping("/ofertasMujer")
    public String getProductsOfertasM(Model model) {
        List<Productos> listaProductos = productosService.listProductos();
        model.addAttribute("productos", listaProductos);
        return "ofertasMujer";
    }

    //Mujer
    @GetMapping("/mujer")
    public String getProductM(Model model) {
        List<Productos> listaProductos = productosService.listProductos();
        model.addAttribute("productos", listaProductos);
        return "mujer";
    }

    //Hombre
    @GetMapping("/hombre")
    public String getProductsH(Model model) {
        List<Productos> listaProductos = productosService.listProductos();
        model.addAttribute("productos", listaProductos);
        return "hombre";
    }

    //Deportiva
    @GetMapping("/deportiva")
    public String getProductsDeportiva(Model model) {
        List<Productos> listaProductos = productosService.listProductos();
        model.addAttribute("productos", listaProductos);
        return "deportiva";
    }

    //Calzado
    @GetMapping("/calzado")
    public String getProductsCalzado(Model model) {
        List<Productos> listaProductos = productosService.listProductos();
        model.addAttribute("productos", listaProductos);
        return "calzado";
    }

    //Joyeria
    @GetMapping("/joyeria")
    public String getProductsJoyeria(Model model) {
        List<Productos> listaProductos = productosService.listProductos();
        model.addAttribute("productos", listaProductos);
        return "joyeria";
    }

    @RequestMapping(path = {"/search"})
    public String home(Productos productos, Model model, String keyword) {
        if (keyword != null) {
            List<Productos> listaProductos = productosService.getByKeyword(keyword);
            model.addAttribute("productos", listaProductos);
        } else {
            List<Productos> listaProductos = productosService.getAllProductos();
            model.addAttribute("productos", listaProductos);
            return "productos";
        }
        return "productos";

    }

    //Clase Opinion de Usuarios
    @GetMapping("/opinion")
    public String indexO(Model model) {
        List<Opinion> listaOpinion = opinionService.listOpinion();
        model.addAttribute("titulo", "Tabla Productos");
        model.addAttribute("opinion", listaOpinion);
        return "opinion";
    }

    @GetMapping("/opinionN")
    public String crearOpinion(Model model) {
        List<Opinion> listaOpinion = opinionService.getAllOpinion();
        model.addAttribute("opinion", new Opinion());
        //model.addAttribute("opinion", listaOpinion);
        return "crearOpinion";
    }

    @PostMapping("/saveOpinion")
    public String guardarOpinion(@ModelAttribute Opinion opinion) {
        opinionService.saveOpinion(opinion);
        return "redirect:/opinion";
    }

    //CARRITO
    @GetMapping("/detalle_producto/{id}")
    public String detalle_producto(@PathVariable("id") Long idProductos, Model model) {
        Productos productos = productosService.getProductosById(idProductos);
        List<Categorias> listaCategorias = categoriasService.getAllCategorias();
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", listaCategorias);
        return "productoHome";
    }

    //
    @PostMapping("/cart")
    public String addCart(@RequestParam Long id, @RequestParam Integer cantidad, Model model) {
        DetalleOrden detalleOrden = new DetalleOrden();
        Productos productos = new Productos();
        double sumaTotal = 0;

        Optional<Productos> optionalProducto = productosService.get(id);
        log.info("Producto anadido: {}", optionalProducto.get());
        log.info("Cantidad: {}", cantidad);
        model.addAttribute("productos", productos);
        productos = optionalProducto.get();

        detalleOrden.setCantidad(cantidad);
        detalleOrden.setPrecio(productos.getPrecio_producto());
        detalleOrden.setNombre(productos.getNombre_producto());
        detalleOrden.setTotal(productos.getPrecio_producto() * cantidad);
        detalleOrden.setProducto(productos);

        //crear validacion para que el producto no se agegue dos veces
        Long idProducto = productos.getId();
        //validar si el id que viene ya se encuentra en la lista detalles
        boolean ingresado = detalles.stream().anyMatch(p -> p.getProducto().getId() == idProducto);

        if (!ingresado) {
            //agregando cada detalle orden a la lista
            detalles.add(detalleOrden);
        }

        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);

        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "carrito";
    }

    //quitar un producto del carrito
    @GetMapping("/delete/cart/{id}")
    public String deleteProductCart(@PathVariable Long id, Model model) {

        //Lista nueva de productos
        List<DetalleOrden> ordenesNuevas = new ArrayList<DetalleOrden>();

        for (DetalleOrden detalleOrden : detalles) {
            if (detalleOrden.getProducto().getId() != id) {
                ordenesNuevas.add(detalleOrden);
            }
        }
        //poner la nueva lista con los productos restantes
        detalles = ordenesNuevas;

        //recalcular los productos
        double sumaTotal = 0;
        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "/carrito";
    }

    @GetMapping("/getCart")
    public String getCart(Model model) {
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        return "carrito";
    }

    @GetMapping("/order")
    //@PreAuthorize("isAuthenticated()")
    public String order(Model model, HttpSession session) {

        Usuario usuario = usuarioService.findById(Long.parseLong(session.getAttribute("id").toString())).get();
        //usuario = usuarioService.findById(id).get();
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        model.addAttribute("usuario", usuario);

        return "resumenorden";
    }

    //guardar la orden
    @GetMapping("/saveOrder")
    public String saveOrder(HttpSession session) {
        Date fechaCreacion = new Date();
        orden.setFechaCreacion(fechaCreacion);
        orden.setNumero(ordenService.generarNumeroOrden());

        Usuario usuario = usuarioService.findById(Long.parseLong(session.getAttribute("id").toString())).get();

        orden.setUsuario(usuario);
        ordenService.save(orden);

        //guardar la parte de los detalles
        for (DetalleOrden dt : detalles) {
            dt.setOrden(orden);
            detalleOrdenService.save(dt);
        }

        //limpiar lista y orden
        orden = new Orden();
        detalles.clear();

        return "redirect:/principal";
    }

    //implementar la parte de la busqueda (Hombre)
    @PostMapping("/search") 
    public String searchProduct(@RequestParam String nombre, Model model) {
        log.info("Nombre del producto {}" + nombre);
        List<Productos> productos = productosService.getAllProductos().stream().filter(p -> p.getNombre_producto()
                .contains(nombre))
                .collect(Collectors.toList());
        model.addAttribute("productos", productos);
        return "/hombre";
    }
    
    //implementar la parte de la busqueda (Hombre)
    @PostMapping("/searchMujer") 
    public String searchProductMujer(@RequestParam String nombre, Model model) {
        log.info("Nombre del producto {}" + nombre);
        List<Productos> productos = productosService.getAllProductos().stream().filter(p -> p.getNombre_producto()
                .contains(nombre))
                .collect(Collectors.toList());
        model.addAttribute("productos", productos);
        return "/mujer";
    }
    
    @PostMapping("/searchCalzado") 
    public String searchProductCalzado(@RequestParam String nombre, Model model) {
        log.info("Nombre del producto {}" + nombre);
        List<Productos> productos = productosService.getAllProductos().stream().filter(p -> p.getNombre_producto()
                .contains(nombre))
                .collect(Collectors.toList());
        model.addAttribute("productos", productos);
        return "/calzado";
    }
    
    @PostMapping("/searchDeportiva") 
    public String searchProductDeportiva(@RequestParam String nombre, Model model) {
        log.info("Nombre del producto {}" + nombre);
        List<Productos> productos = productosService.getAllProductos().stream().filter(p -> p.getNombre_producto()
                .contains(nombre))
                .collect(Collectors.toList());
        model.addAttribute("productos", productos);
        return "/deportiva";
    }
    
    @PostMapping("/searchJoyeria") 
    public String searchProductJoyeria(@RequestParam String nombre, Model model) {
        log.info("Nombre del producto {}" + nombre);
        List<Productos> productos = productosService.getAllProductos().stream().filter(p -> p.getNombre_producto()
                .contains(nombre))
                .collect(Collectors.toList());
        model.addAttribute("productos", productos);
        return "/joyeria";
    }
    
    @PostMapping("/searchOfertasM") 
    public String searchProductOfertasM(@RequestParam String nombre, Model model) {
        log.info("Nombre del producto {}" + nombre);
        List<Productos> productos = productosService.getAllProductos().stream().filter(p -> p.getNombre_producto()
                .contains(nombre))
                .collect(Collectors.toList());
        model.addAttribute("productos", productos);
        return "/ofertasMujer";
    }
    
    @PostMapping("/searchOfertasH") 
    public String searchProductOfertasH(@RequestParam String nombre, Model model) {
        log.info("Nombre del producto {}" + nombre);
        List<Productos> productos = productosService.getAllProductos().stream().filter(p -> p.getNombre_producto()
                .contains(nombre))
                .collect(Collectors.toList());
        model.addAttribute("productos", productos);
        return "/ofertasHombre";
    }
    
    
    
    //ver las compras del usuario por usuario
    @GetMapping("/compras")
    public String obtenerCompras(HttpSession session, Model model) {
        model.addAttribute("sesion", session.getAttribute("id"));
        Usuario usuario = usuarioService.findById(Long.parseLong(session.getAttribute("id").toString())).get();
        List<Orden> ordenes = ordenService.findByUsuario(usuario);

        model.addAttribute("ordenes", ordenes);
        return "compras";
    }

    //cuales detalles pertencen a la orden
    @GetMapping("/detalle/{id}")
    public String detalleCompra(@PathVariable Long id, HttpSession session, Model model) {
        log.info("Id de la orden: {}", id);
        Optional<Orden> orden = ordenService.findById(id);
        model.addAttribute("detalles", orden.get().getDetalle());
        
        //session
        model.addAttribute("sesion", session.getAttribute("id"));

        return "detallecompra";
    }
    
    //Administrador
    @GetMapping("/usuarios")
    public String usuarios(Model model){
        model.addAttribute("usuarios", usuarioService.findALL());
        return "usuarios";
    }

}
