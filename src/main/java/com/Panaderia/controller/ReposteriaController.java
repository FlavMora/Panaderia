package com.Panaderia.controller;

import com.Panaderia.domain.Reposteria;
import com.Panaderia.service.ReposteriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reposterias")
public class ReposteriaController {

  private final ReposteriaService reposteriaService;

  public ReposteriaController(ReposteriaService reposteriaService) {
    this.reposteriaService = reposteriaService;
  }

  @GetMapping("/listado")
  public String getAllReposterias(Model model) {
    List<Reposteria> reposterias = reposteriaService.findAll();
    model.addAttribute("reposterias", reposterias);
    return "reposterias/listado";
  }

  @GetMapping("/modifica/{id}")
  public String updatePostre(@PathVariable Integer id, Model model) {
    Optional<Reposteria> reposteria = reposteriaService.findById(id);
    reposteria.ifPresent(p -> model.addAttribute("reposteria", p));
    return "reposterias/modifica";
  }

  @GetMapping("/nuevo")
  public String createReposteriaForm(Model model) {
    model.addAttribute("reposteria", new Postre());
    return "reposterias/nuevo";
  }

  @PostMapping("/guardar")
  public String saveReposteria(@ModelAttribute Reposteria reposteria) {
   reposteriaService.save(reposteria);
    return "redirect:/postres/listado";
  }

  @GetMapping("/eliminar/{id}")
  public String deleteReposteria(@PathVariable Integer id) {
    reposteriaService.deleteById(id);
    return "redirect:/reposterias/listado";
  }
}