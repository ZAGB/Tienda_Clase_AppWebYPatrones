
package com.Tienda_Clase_AppWebYPatrones.DAO;

import com.Tienda_Clase_AppWebYPatrones.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long>{
    
}
