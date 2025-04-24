package com.Panaderia.controller;

import com.Panaderia.domain.Articulo;
import com.Panaderia.domain.Factura;
import com.Panaderia.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/facturar")
@SessionAttributes("carrito")
public class FacturarController {

  @Autowired
  private FacturaService facturaService;

  @GetMapping("/carrito")
  public String mostrarFormularioFacturacion(
      @ModelAttribute("carrito") List<Articulo> carrito,
      Model model) {
    if (carrito == null || carrito.isEmpty()) {
      return "redirect:/carrito/listado";
    }
    BigDecimal total = carrito.stream()
        .map(item -> item.getPrecio().multiply(BigDecimal.valueOf(item.getCantidad())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    model.addAttribute("listaItems", carrito);
    model.addAttribute("carritoTotal", total);
    return "facturar/carrito";
  }

  @PostMapping("/carrito")
  public String procesarFacturacion(
      @ModelAttribute("carrito") List<Articulo> carrito,
      SessionStatus status,
      Model model) {
    if (carrito == null || carrito.isEmpty()) {
      return "redirect:/carrito/listado";
    }
    try {
      Factura factura = facturaService.crearFactura(carrito);
      carrito.clear();
      status.setComplete();
      model.addAttribute("facturaId", factura.getId());
      return "redirect:/facturar/exito";
    } catch (Exception e) {
      return "redirect:/carrito/listado?error";
    }
  }

  @GetMapping("/exito")
  public String mostrarExito() {
    return "facturar/exito";
  }
}