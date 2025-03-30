package com.Panaderia.controller;

import com.Panaderia.domain.Postre;
import com.Panaderia.service.PostreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/postres")
public class PostreController {

  private final PostreService postreService;

  public PostreController(PostreService postreService) {
    this.postreService = postreService;
  }

  // Obtener todos los postres
  @GetMapping("/listado")
  public String getAllPostres(Model model) {
    List<Postre> postres = postreService.findAll();
    model.addAttribute("postres", postres);
    return "postres/listado";
  }

  // Obtener un postre por ID para modificar
  @GetMapping("/modifica/{id}")
  public String updatePostre(@PathVariable Integer id, Model model) {
    Optional<Postre> postre = postreService.findById(id);
    postre.ifPresent(p -> model.addAttribute("postre", p));
    return "postres/modifica";
  }

  // Formulario para crear un nuevo postre
  @GetMapping("/nuevo")
  public String createPostreForm(Model model) {
    model.addAttribute("postre", new Postre());
    return "postres/nuevo";
  }

  // Guardar un nuevo postre
  @PostMapping("/guardar")
  public String savePostre(@ModelAttribute Postre postre) {
    postreService.save(postre);
    return "redirect:/postres/listado";
  }

  // Eliminar un postre
  @GetMapping("/eliminar/{id}")
  public String deletePostre(@PathVariable Integer id) {
    postreService.deleteById(id);
    return "redirect:/postres/listado";
  }
}