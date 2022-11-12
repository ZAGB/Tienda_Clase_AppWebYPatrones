
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
public class ArticuloController {
    
    @Autowired   
    private ArticuloService articuloService;
    
    @GetMapping("/articulo/listado")
    public String page(Model model) {
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        return "/articulo/listado";
    }
    
    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo){  
        return "/articulo/modifica";
    }
    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo){
       articuloService.save(articulo);
       return "redirect:/articulo/listado";
        
    }
    //mofificarArticulo/5
    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model){
        articulo= articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modifica";
        
    }
     //eliminarArticulo/5
    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo){
        articuloService.delete(articulo);
       
        return "redirect:/articulo/listado";
        
    }
    
}
