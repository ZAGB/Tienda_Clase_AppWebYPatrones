
package com.Tienda_Clase_AppWebYPatrones.Service;

import com.Tienda_Clase_AppWebYPatrones.DAO.ClienteDao;
import com.Tienda_Clase_AppWebYPatrones.DAO.CreditoDao;
import com.Tienda_Clase_AppWebYPatrones.domain.Cliente;
import com.Tienda_Clase_AppWebYPatrones.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



//lo primero a hacer es crear esta clase y implementar la interface de ClienteService para tener los metodos 
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired 
    private ClienteDao clienteDao;
    
    @Autowired 
    private CreditoDao creditoDao;
    
    @Override
    @Transactional(readOnly =true)
    public List<Cliente> getClientes() {
        var clientes = (List<Cliente>)clienteDao.findAll();
        return clientes;
        
        // eso es lo mismo a: return (List<Cliente>)clienteDao.findAll();  
    }

    @Override
    @Transactional(readOnly =true)
    public Cliente getCliente(Cliente cliente) {
       return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();
        credito= creditoDao.save(credito);
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
       clienteDao.delete(cliente);
    }
    
    
    
}
