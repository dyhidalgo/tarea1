package com.tarea1.service;

import com.tarea1.entity.Orden;
import com.tarea1.entity.Usuario;
import com.tarea1.repository.OrdenRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenService implements IOrdenService {
    
    @Autowired
    private OrdenRepository ordenRepository;
    
    @Override
    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }
    
    @Override
    public String generarNumeroOrden(){
        int numero = 0;
        String numeroConcatenado = "";
        
        //Obtener todas las ordenes y el ultimo numero de orden
        List<Orden> ordenes = findAll();
        
        List<Integer> numeros = new ArrayList<Integer>();
        
        ordenes.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumero())));
        
        if(ordenes.isEmpty()){
            numero=1;
        }else{
            //se obtiene el mayor
            numero=numeros.stream().max(Integer::compare).get();
            //le aumentamos 1
            numero++;
        }
        
        if(numero<10){
            numeroConcatenado = "000000000" + String.valueOf(numero);
        }else if(numero<100){
            numeroConcatenado = "00000000" + String.valueOf(numero);
        }else if(numero<1000){
            numeroConcatenado = "0000000" + String.valueOf(numero);
        }else if(numero<10000){
            numeroConcatenado = "000000" + String.valueOf(numero);
        }
        
        return numeroConcatenado;
    }

    @Override
    public List<Orden> findByUsuario(Usuario usuario) {
        return ordenRepository.findByUsuario(usuario);
    }

    @Override
    public Optional<Orden> findById(Long id) {
        return ordenRepository.findById(id);
    }
    
    
    
}
