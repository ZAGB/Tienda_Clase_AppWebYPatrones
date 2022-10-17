
package com.Tienda_Clase_AppWebYPatrones.Service;

import com.Tienda_Clase_AppWebYPatrones.domain.Cliente;
import java.util.List;


public interface ClienteService {
    
    //Aca se definen los metodos para hacer cambios a la lista en MYSQL 
    // Varias clases pueden implementar estos metodos por ser interface
    
    public List<Cliente> getClientes();
    

    public Cliente getCliente(Cliente cliente);
    
    
    public void save(Cliente cliente);

    public void delete(Cliente cliente);


}
