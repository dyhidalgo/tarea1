
package com.tarea1.repository;

import com.tarea1.entity.Productos;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductosRepository extends CrudRepository<Productos, Long> {
    @Query(value = "select * from productos p where p.Id like %:Keyword%", nativeQuery = true)
    List<Productos> findByKeyword(@Param("Keyword") String Keyword);
}
