package com.Panaderia.controller;

import com.Panaderia.domain.Postre;
import com.Panaderia.service.PostreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/postres")
public class PostreController {

  private final PostreService postreService;

  public PostreController(PostreService postreService) {
    this.postreService = postreService;
  }

  @GetMapping("/listado")
  public String getAllPostres(Model model) {
    List<Postre> postres = postreService.findAll();
    model.addAttribute("postres", postres);
    return "postres/listado";
  }

  @GetMapping("/modifica/{id}")
  public String updatePostre(@PathVariable Integer id, Model model) {
    Optional<Postre> postre = postreService.findById(id);
    postre.ifPresent(p -> model.addAttribute("postre", p));
    return "postres/modifica";
  }

  @GetMapping("/nuevo")
  public String createPostreForm(Model model) {
    model.addAttribute("postre", new Postre());
    return "postres/nuevo";
  }

  @PostMapping("/guardar")
  public String savePostre(@ModelAttribute Postre postre) {
    postreService.save(postre);
    return "redirect:/postres/listado";
  }

  @GetMapping("/eliminar/{id}")
  public String deletePostre(@PathVariable Integer id) {
    postreService.deleteById(id);
    return "redirect:/postres/listado";
  }
}