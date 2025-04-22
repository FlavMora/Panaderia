package com.Panaderia.controller;

import com.Panaderia.domain.Articulo;
import com.Panaderia.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.Panaderia.service.PastelService;
import com.Panaderia.service.PostreService;
import com.Panaderia.service.ReposteriaService;
import com.Panaderia.domain.Pastel;
import com.Panaderia.domain.Postre;
import com.Panaderia.domain.Reposteria;

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

    @GetMapping("/")
    public String listado(Model model) {
        var pasteles = pastelService.findAll();
        var postres = postreService.findAll();
        var reposterias = reposteriaService.findAll();

        model.addAttribute("pasteles", pasteles);
        model.addAttribute("postres", postres);
        model.addAttribute("reposterias", reposterias);

        return "/index";
    }

    @GetMapping("/carrito/agregar/{tipo}/{idPan}")
    public ModelAndView agregarArticulo(
            @PathVariable String tipo,
            @PathVariable Long idPan,
            Model model) {

        Articulo articulo = new Articulo();
        articulo.setTipo(tipo);
        articulo.setIdPan(idPan);

        Articulo articulo2 = articuloService.get(articulo);

        if (articulo2 == null) {
            switch (tipo.toLowerCase()) {
                case "pastel":
                    Pastel pastel = pastelService.getPastelById(idPan);
                    articulo2 = new Articulo(pastel);
                    break;
                case "postre":
                    Postre postre = postreService.getPostreById(idPan);
                    articulo2 = new Articulo(postre);
                    break;
                case "reposteria":
                    Reposteria reposteria = reposteriaService.getReposteriaById(idPan);
                    articulo2 = new Articulo(reposteria);
                    break;
                default:
                    return new ModelAndView("redirect:/");
            }
            articuloService.save(articulo2);
        } else {
            articulo2.setCantidad(articulo2.getCantidad() + 1);
            articuloService.save(articulo2);
        }

        var articulos = articuloService.gets();
        model.addAttribute("listaArticulos", articulos);

        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    }

    @GetMapping("/carrito/eliminar/{tipo}/{idPan}")
    public String eliminarArticulo(
            @PathVariable String tipo,
            @PathVariable Long idPan) {

        Articulo articulo = new Articulo();
        articulo.setTipo(tipo);
        articulo.setIdPan(idPan);
        articuloService.delete(articulo);

        return "redirect:/carrito/listado";
    }

    @GetMapping("/carrito/modificar/{tipo}/{idPan}")
    public String modificarArticulo(
            @PathVariable String tipo,
            @PathVariable Long idPan,
            Model model) {

        Articulo articulo = new Articulo();
        articulo.setTipo(tipo);
        articulo.setIdPan(idPan);
        articulo = articuloService.get(articulo);

        model.addAttribute("articulo", articulo);
        return "/carrito/modificar";
    }
}
