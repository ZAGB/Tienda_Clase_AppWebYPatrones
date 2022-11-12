
package com.Tienda_Clase_AppWebYPatrones.Service;

import com.Tienda_Clase_AppWebYPatrones.domain.Articulo;
import java.util.List;


public interface ArticuloService {
    
    //Aca se definen los metodos para hacer cambios a la lista en MYSQL 
    // Varias clases pueden implementar estos metodos por ser interface
    
    public List<Articulo> getArticulos(boolean activos);
    

    public Articulo getArticulo(Articulo cliente);
    
    
    public void save(Articulo cliente);

    public void delete(Articulo cliente);


}
