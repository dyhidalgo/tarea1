package com.tarea1.service;

import com.tarea1.entity.DetalleOrden;
import com.tarea1.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleOrdenService implements IDetalleOrdenService {

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;
    
    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }
  
    
}
