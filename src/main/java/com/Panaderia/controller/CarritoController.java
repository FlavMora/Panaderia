package com.Panaderia.controller;

import com.Panaderia.domain.Articulo;
import com.Panaderia.service.ArticuloService;
import com.Panaderia.service.PastelService;
import com.Panaderia.service.PostreService;
import com.Panaderia.service.ReposteriaService;
import com.Panaderia.domain.Pastel;
import com.Panaderia.domain.Postre;
import com.Panaderia.domain.Reposteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carrito")
@SessionAttributes("carrito")
public class CarritoController {

    @Autowired
    private ArticuloService articuloService;
    @Autowired
    private PastelService pastelService;
    @Autowired
    private PostreService postreService;
    @Autowired
    private ReposteriaService reposteriaService;

    @ModelAttribute("carrito")
    public List<Articulo> inicializarCarrito() {
        return new ArrayList<>();
    }

    @GetMapping({ "/", "/listado" })
    public String verCarrito(
            @ModelAttribute("carrito") List<Articulo> carrito,
            Model model) {
        model.addAttribute("listaItems", carrito);
        model.addAttribute("listaTotal", carrito.size());

        BigDecimal total = carrito.stream()
                .map(a -> a.getPrecio().multiply(new BigDecimal(a.getCantidad())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("carritoTotal", total);

        return "carrito/listado";
    }

    @GetMapping("/agregar/{tipo}/{idPan}")
    public String agregarArticulo(
            @PathVariable String tipo,
            @PathVariable Integer idPan,
            @ModelAttribute("carrito") List<Articulo> carrito) {

        Articulo clave = new Articulo();
        clave.setTipo(tipo);
        clave.setIdPan(idPan);

        Articulo existente = articuloService.get(clave, carrito);

        if (existente != null) {
            existente.setCantidad(existente.getCantidad() + 1);
        } else {
            Articulo nuevo;
            switch (tipo.toLowerCase()) {
                case "pastel":
                    Pastel pastel = pastelService.findById(idPan)
                            .orElseThrow(() -> new RuntimeException("Pastel no encontrado"));
                    nuevo = new Articulo(pastel);
                    break;
                case "postre":
                    Postre postre = postreService.findById(idPan)
                            .orElseThrow(() -> new RuntimeException("Postre no encontrado"));
                    nuevo = new Articulo(postre);
                    break;
                case "reposteria":
                    Reposteria rep = reposteriaService.findById(idPan)
                            .orElseThrow(() -> new RuntimeException("Repostería no encontrada"));
                    nuevo = new Articulo(rep);
                    break;
                default:
                    return "redirect:/";
            }
            articuloService.save(nuevo, carrito);
        }

        return "redirect:/carrito/listado";
    }

    @GetMapping("/eliminar/{tipo}/{idPan}")
    public String eliminarArticulo(
            @PathVariable String tipo,
            @PathVariable Integer idPan,
            @ModelAttribute("carrito") List<Articulo> carrito) {

        Articulo a = new Articulo();
        a.setTipo(tipo);
        a.setIdPan(idPan);
        articuloService.delete(a, carrito);

        return "redirect:/carrito/listado";
    }

    @GetMapping("/modificar/{tipo}/{idPan}")
    public String modificarArticuloForm(
            @PathVariable String tipo,
            @PathVariable Integer idPan,
            @ModelAttribute("carrito") List<Articulo> carrito,
            Model model) {

        Articulo encontrado = carrito.stream()
                .filter(item -> item.getTipo().equalsIgnoreCase(tipo)
                        && item.getIdPan().equals(idPan))
                .findFirst()
                .orElse(null);

        if (encontrado == null) {
            return "redirect:/carrito/listado";
        }

        model.addAttribute("item", encontrado);
        return "carrito/modificar";
    }

    @PostMapping("/modificar")
    public String procesarModificacion(
            @RequestParam("tipo") String tipo,
            @RequestParam("idPan") Integer idPan,
            @RequestParam("cantidad") Integer cantidad,
            @ModelAttribute("carrito") List<Articulo> carrito) {

        Articulo articulo = carrito.stream()
                .filter(item -> item.getTipo().equalsIgnoreCase(tipo) && item.getIdPan().equals(idPan))
                .findFirst()
                .orElse(null);

        if (articulo != null) {
            articuloService.actualiza(articulo, carrito);

            if (cantidad <= 0) {
                articuloService.delete(articulo, carrito);
            } else {
                articulo.setCantidad(cantidad);
            }
        }

        return "redirect:/carrito/listado";
    }

    @GetMapping("/vaciar")
    public String vaciarCarrito(@ModelAttribute("carrito") List<Articulo> carrito) {
        carrito.clear();
        return "redirect:/carrito/listado";
    }
}