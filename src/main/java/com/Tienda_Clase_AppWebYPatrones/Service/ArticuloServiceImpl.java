
package com.Tienda_Clase_AppWebYPatrones.Service;

import com.Tienda_Clase_AppWebYPatrones.DAO.ArticuloDao;
import com.Tienda_Clase_AppWebYPatrones.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



//lo primero a hacer es crear esta clase y implementar la interface de ArticuloService para tener los metodos 
@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired 
    private ArticuloDao clienteDao;
    
    @Override
    @Transactional(readOnly =true)
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>)clienteDao.findAll();
        if (activos) {lista.removeIf(e -> !e.isActivo());}
        return lista;
        
        // eso es lo mismo a: return (List<Articulo>)clienteDao.findAll();  
    }

    @Override
    @Transactional(readOnly =true)
    public Articulo getArticulo(Articulo cliente) {
       return clienteDao.findById(cliente.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Articulo cliente) {
       clienteDao.delete(cliente);
    }
    
    
    
}
