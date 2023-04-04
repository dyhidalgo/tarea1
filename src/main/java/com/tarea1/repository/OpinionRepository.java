
package com.tarea1.repository;
import com.tarea1.entity.Opinion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diker Hidalgo
 */
@Repository
public interface OpinionRepository extends CrudRepository <Opinion, Long>{

}
