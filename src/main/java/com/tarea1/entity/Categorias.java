/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea1.entity;
import java.io.Serializable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author Diker Hidalgo
 */

@Entity
@Table(name="categoria")
public class Categorias  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Categoria;
    private String tipo_categoria;
/*
    @OneToMany
    @JoinColumn (name= "id_usuario_producto")
    private Productos Productos;*/


    public long getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(long id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public String getTipo_categoria() {
        return tipo_categoria;
    }

    public void setTipo_categoria(String tipo_categoria) {
        this.tipo_categoria = tipo_categoria;
    }
    
    
}
