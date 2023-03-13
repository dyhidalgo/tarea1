
package com.tarea1.repository;
import com.tarea1.entity.Categorias;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends CrudRepository <Categorias, Long>{
    
}
