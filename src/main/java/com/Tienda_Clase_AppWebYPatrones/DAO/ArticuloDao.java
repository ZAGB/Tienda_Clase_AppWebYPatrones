
package com.Tienda_Clase_AppWebYPatrones.DAO;


import com.Tienda_Clase_AppWebYPatrones.domain.Articulo;
import org.springframework.data.repository.CrudRepository;


public interface ArticuloDao extends CrudRepository<Articulo, Long>{
    
}
