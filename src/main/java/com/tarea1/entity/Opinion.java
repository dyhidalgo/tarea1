package com.tarea1.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Diker Hidalgo
 */

@Entity
@Table(name = "opinion")
public class Opinion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opinion")
    private long id_opinion;
    
    private String nombre;
    private String correo;
    private String comentario;
    
//    @ManyToOne
//    @JoinColumn(name = "id_usuario")

    public long getId_opinion() {
        return id_opinion;
    }

    public void setId_opinion(long id_opinion) {
        this.id_opinion = id_opinion;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
