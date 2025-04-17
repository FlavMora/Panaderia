package com.Panaderia.controller;

import com.Panaderia.domain.Resena;
import com.Panaderia.service.ResenaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resena")
public class ResenaController {

  private final ResenaService resenaService;

  public ResenaController(ResenaService resenaService) {
    this.resenaService = resenaService;
  }

  @GetMapping("/listado")
  public String listarResenas(Model model) {
    model.addAttribute("resenas", resenaService.obtenerTodas());
    model.addAttribute("resena", new Resena());
    return "resena/listado";
  }

  @PostMapping("/guardar")
  public String guardarResena(@ModelAttribute Resena resena,
      BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("resenas", resenaService.obtenerTodas());
      return "resena/listado";
    }
    resenaService.guardar(resena);
    return "redirect:/resena/listado?exito=true";
  }

  @GetMapping("/eliminar/{id}")
  public String eliminarResena(@PathVariable Integer id) {
    resenaService.eliminar(id);
    return "redirect:/resena/listado?eliminado=true";
  }
}