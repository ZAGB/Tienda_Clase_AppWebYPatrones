
package com.Tienda_Clase_AppWebYPatrones.DAO;


import com.Tienda_Clase_AppWebYPatrones.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDao extends CrudRepository<Categoria, Long>{
    
}
