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

/**
 *
 * @author Diker Hidalgo
 */
@Controller
public class ProductosController {

    @Autowired
    private ICategoriasService categoriasService;
    /*@Autowired
    private IComentariosService comentariosService;
    @Autowired
    private IDetalleOrdenService detalleOrdenService;
    @Autowired
    private IOrdenesService ordenesService;*/
    @Autowired
    private IProductosService productosService;
   /* @Autowired
    private ITipoService tipoService;
    @Autowired
    private IUsuariosService usuariosService;*/

    @GetMapping("/categoria")
    public String Index(Model model) {
        List<Categorias> listaCategorias = categoriasService.getAllCategorias();
        model.addAttribute("titulo", "Tabla Categorias");
        model.addAttribute("categorias", listaCategorias);
        return "categoria";
    }

    @GetMapping("/categoriaN")
    public String crearCategoria(Model model) {
        List<Productos> listaProductos = productosService.listProductos();
        model.addAttribute("categoria", new Categorias());
        model.addAttribute("productos", listaProductos);
        return "crear";
    }
}
