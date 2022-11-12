
package com.Tienda_Clase_AppWebYPatrones.controller;

import com.Tienda_Clase_AppWebYPatrones.DAO.CategoriaDao;
import com.Tienda_Clase_AppWebYPatrones.Service.CategoriaService;
import com.Tienda_Clase_AppWebYPatrones.domain.Categoria;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class CategoriaController {
    
    @Autowired   
    private CategoriaService categoriaService;
    
    @GetMapping("/categoria/listado")
    public String page(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/categoria/listado";
    }
    
    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria){  
        return "/categoria/modifica";
    }
    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria){
       categoriaService.save(categoria);
       return "redirect:/categoria/listado";
        
    }
    //mofificarCategoria/5
    @GetMapping("/categoria/modificar/{idCategoria}")
    public String modificarCategoria(Categoria categoria, Model model){
        categoria= categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
        
    }
     //eliminarCategoria/5
    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminarCategoria(Categoria categoria){
        categoriaService.delete(categoria);
       
        return "redirect:/categoria/listado";
        
    }
    
}
