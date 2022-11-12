
package com.Tienda_Clase_AppWebYPatrones.controller;

import com.Tienda_Clase_AppWebYPatrones.DAO.ArticuloDao;
import com.Tienda_Clase_AppWebYPatrones.Service.ArticuloService;
import com.Tienda_Clase_AppWebYPatrones.domain.Articulo;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired   
    private ArticuloService articuloService;
    
    @GetMapping("/")
    public String page(Model model) {
        log.info("Ahora se usa arquitectura MVC");

        var articulos = articuloService.getArticulos(true);

        model.addAttribute("articulos", articulos);
        
        return "index";
    }
    
}
