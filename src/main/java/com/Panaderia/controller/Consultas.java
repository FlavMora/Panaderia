package com.Panaderia.controller;
import com.Panaderia.domain.Postre;
import com.Panaderia.domain.Pastel;
import com.Panaderia.domain.Reposteria;

import com.Panaderia.service.PostreService;
import com.Panaderia.service.PastelService;
import com.Panaderia.service.ReposteriaService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;



@Controller
@RequestMapping("/consultas")
public class Consultas {

    @Autowired
    private PastelService pastelService;
    @Autowired
    private PostreService postreService;
     @Autowired
    private ReposteriaService reposteriaService;

    //Consultas ampliadas
    @GetMapping("/listado")
    public String listado(Model model) {
    var pasteles = pastelService.findAll();
    var postres = postreService.findAll();
    var reposterias = reposteriaService.findAll();

    model.addAttribute("pasteles", pasteles);
    model.addAttribute("postres", postres);
    model.addAttribute("reposterias", reposterias);

    return "/consultas/listado";
}
    
@PostMapping("/query1")
    public String consultaQuery1(
    @RequestParam(value = "precioInf") double precioInf,
    @RequestParam(value = "precioSup") double precioSup,
    Model model) {

    var pasteles = pastelService.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    var postres = postreService.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    var reposterias = reposteriaService.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);

    model.addAttribute("pasteles", pasteles);
    model.addAttribute("postres", postres);
    model.addAttribute("reposterias", reposterias);
    model.addAttribute("precioInf", precioInf);
    model.addAttribute("precioSup", precioSup);

    return "/consultas/listado";
}

}