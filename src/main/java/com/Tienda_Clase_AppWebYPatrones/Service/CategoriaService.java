
package com.Tienda_Clase_AppWebYPatrones.Service;

import com.Tienda_Clase_AppWebYPatrones.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
    //Aca se definen los metodos para hacer cambios a la lista en MYSQL 
    // Varias clases pueden implementar estos metodos por ser interface
    
    public List<Categoria> getCategorias(boolean activos);
    

    public Categoria getCategoria(Categoria cliente);
    
    
    public void save(Categoria cliente);

    public void delete(Categoria cliente);


}
