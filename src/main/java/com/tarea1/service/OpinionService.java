package com.tarea1.service;

import com.tarea1.entity.Opinion;
import com.tarea1.entity.Productos;
import com.tarea1.repository.OpinionRepository;
import com.tarea1.repository.ProductosRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Diker Hidalgo
 */
@Service
public class OpinionService implements IOpinionService {

    @Autowired
    private OpinionRepository opinionRepository;

    /*
    @Override
    public List<Productos> listProductos() {
        return (List<Productos>) opinionRepository.findAll();
    }


    @Override
    public void saveOpinion(Opinion opinion) {
        opinionRepository.save(opinion);
    }

    }
     */
    @Override
    public List<Opinion> listOpinion() {
        return (List<Opinion>) opinionRepository.findAll();
    }

    @Override
    public void saveOpinion(Opinion opinion) {
        opinionRepository.save(opinion);
    }

    @Override
    public List<Opinion> getAllOpinion() {
        return (List<Opinion>) opinionRepository.findAll();
    }

}
