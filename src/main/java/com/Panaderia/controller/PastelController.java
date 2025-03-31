package com.Panaderia.controller;

import com.Panaderia.domain.Postre;
import com.Panaderia.service.PastelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pasteles")
public class PastelController {
 
    
  @Autowired
  private PastelService pastelService;

  public PastelController(PastelService pastelService) {
    this.pastelService = pastelService;
  }

  @GetMapping("/listado")
  public String getAllPostres(Model model) {
    List<Pastel> pasteles = pastelService.findAll();
    model.addAttribute("pasteles", pasteles);
    return "pasteles/listado";
  }

  @GetMapping("/modifica/{id}")
  public String updatePastel(@PathVariable Integer id, Model model) {
    Optional<Pastel> pastel = pastelService.findById(id);
    pastel.ifPresent(p -> model.addAttribute("pastel", p));
    return "pasteles/modifica";
  }

  @GetMapping("/nuevo")
  public String createPastelForm(Model model) {
    model.addAttribute("pastel", new Pastel());
    return "pasteles/nuevo";
  }

  @PostMapping("/guardar")
  public String savePastel(@ModelAttribute Pastel pastel) {
    pastelService.save(pastel);
    return "redirect:/pasteles/listado";
  }

  @GetMapping("/eliminar/{id}")
  public String deletePastel(@PathVariable Integer id) {
    pastelService.deleteById(id);
    return "redirect:/pasteles/listado";
  }
}