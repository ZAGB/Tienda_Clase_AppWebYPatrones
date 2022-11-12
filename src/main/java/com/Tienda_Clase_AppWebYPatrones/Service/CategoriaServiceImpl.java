
package com.Tienda_Clase_AppWebYPatrones.Service;

import com.Tienda_Clase_AppWebYPatrones.DAO.CategoriaDao;
import com.Tienda_Clase_AppWebYPatrones.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



//lo primero a hacer es crear esta clase y implementar la interface de CategoriaService para tener los metodos 
@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired 
    private CategoriaDao clienteDao;
    
    @Override
    @Transactional(readOnly =true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>)clienteDao.findAll();
        if (activos) {lista.removeIf(e -> !e.isActivo());}
        return lista;
        
        // eso es lo mismo a: return (List<Categoria>)clienteDao.findAll();  
    }

    @Override
    @Transactional(readOnly =true)
    public Categoria getCategoria(Categoria cliente) {
       return clienteDao.findById(cliente.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Categoria cliente) {
       clienteDao.delete(cliente);
    }
    
    
    
}
