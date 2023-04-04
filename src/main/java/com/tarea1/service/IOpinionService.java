
package com.tarea1.service;

import com.tarea1.entity.Opinion;

import java.util.List;

/**
 *
 * @author Diker Hidalgo
 */
public interface IOpinionService {

    public List<Opinion> listOpinion();
    //public Opinion getOpinionById(long id);
    public void saveOpinion(Opinion opinion);
    public List<Opinion> getAllOpinion();

}
