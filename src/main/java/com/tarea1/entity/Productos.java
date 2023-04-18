package com.tarea1.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Productos implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre_producto;
    private String descripcion_producto;
    private int precio_producto;
    private String nombre_imagen;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categorias categorias;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public String getNombre_imagen() {
        return nombre_imagen;
    }

    public void setNombre_imagen(String nombre_imagen) {
        this.nombre_imagen = nombre_imagen;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }
}
