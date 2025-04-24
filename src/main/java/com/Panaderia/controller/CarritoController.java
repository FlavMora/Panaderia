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
        return articuloService.gets();
    }

    @GetMapping({ "/", "/listado" })
    public String verCarrito(@ModelAttribute("carrito") List<Articulo> carrito, Model model) {
        model.addAttribute("listaItems", carrito);
        model.addAttribute("listaTotal", carrito.size());
        return "carrito/listado";
    }

    @GetMapping("/agregar/{tipo}/{idPan}")
    public String agregarArticulo(
            @PathVariable String tipo,
            @PathVariable Integer idPan,
            @ModelAttribute("carrito") List<Articulo> carrito,
            Model model) {

        Articulo clave = new Articulo();
        clave.setTipo(tipo);
        clave.setIdPan(idPan);

        Articulo existente = articuloService.get(clave);

        if (existente != null) {
            existente.setCantidad(existente.getCantidad() + 1);
            return "redirect:/carrito/listado";
        }

        if (existente == null) {
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
            articuloService.save(nuevo);
            carrito.add(nuevo);
        }

        model.addAttribute("listaArticulos", carrito);
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
        articuloService.delete(a);

        carrito.removeIf(item -> item.getTipo().equals(tipo) && item.getIdPan().equals(idPan));
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

        // Busca el artículo en el carrito
        Articulo articulo = carrito.stream()
                .filter(item -> item.getTipo().equals(tipo) && item.getIdPan().equals(idPan))
                .findFirst()
                .orElse(null);

        if (articulo != null) {
            articulo.setCantidad(cantidad);
            articuloService.actualiza(articulo);
        }

        return "redirect:/carrito/listado";
    }
}