/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea1.controller;

/*Importacion de entidades del proyecto*/
import com.tarea1.entity.Categorias;
/*import com.tarea1.entity.Comentarios;
import com.tarea1.entity.DetalleOrden;
import com.tarea1.entity.Tipo;
import com.tarea1.entity.Usuarios;
import com.tarea1.entity.Ordenes;*/
import com.tarea1.entity.Productos;


/*Importacion de interfaces del proyecto*/
import com.tarea1.service.ICategoriasService;
/*import com.tarea1.service.IComentariosService;
import com.tarea1.service.IDetalleOrdenService;
import com.tarea1.service.IOrdenesService;*/
import com.tarea1.service.IProductosService;
/*import com.tarea1.service.ITipoService;
import com.tarea1.service.IUsuariosService;*/

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductosController {

    @Autowired
    private ICategoriasService categoriasService;

    @Autowired
    private IProductosService productosService;

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
    public String home(Productos productos, Model model, String keyword){
        if(keyword!=null){
            List<Productos> listaProductos = productosService.getByKeyword(keyword);
            model.addAttribute("productos",listaProductos);
        }else{
            List<Productos> listaProductos  = productosService.getAllProductos();
            model.addAttribute("productos",listaProductos);
            return "productos";
        }
        return "productos";
      
    }
}
