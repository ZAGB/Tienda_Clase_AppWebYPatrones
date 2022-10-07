
package com.Tienda_Clase_AppWebYPatrones.controller;

import com.Tienda_Clase_AppWebYPatrones.DAO.ClienteDao;
import com.Tienda_Clase_AppWebYPatrones.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired 
    private ClienteDao clienteDao;
    
    @GetMapping("/")
    public String page(Model model) {
        log.info("Ahora se usa arquitectura MVC");
        
        Cliente cliente =new Cliente("Osiris", "Gonzalez", "Osiris@gmail.com", "8820-2655");
        //Cliente cliente2 =new Cliente("Zujeily", "Gonzalez", "Zu@gmail.com", "8820-2288");
        
        //var clientes = Arrays.asList(cliente, cliente2);
        
        var clientes = clienteDao.findAll();
                
        model.addAttribute("cliente", cliente);
        
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
    
}
