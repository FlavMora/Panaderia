/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Panaderia.service.Impl;

import com.Panaderia.dao.PedidoDao;
import com.Panaderia.dao.OrdenDao;
import com.Panaderia.domain.Reposteria;
import com.Panaderia.domain.Pastel;
import com.Panaderia.domain.Postre;

//import com.Panaderia.domain.Usuario;
import com.Panaderia.domain.Pedido;
import com.Panaderia.domain.Articulo;
import com.Panaderia.domain.Orden;
import com.Panaderia.service.ArticuloService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Panaderia.dao.ReposteriaDao;
import com.Panaderia.dao.PastelDao;
import com.Panaderia.dao.PostreDao;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    // @Autowired
    // private UsuarioService usuarioService;

    @Autowired
    private PastelDao pastelDao;

    @Autowired
    private PostreDao postreDao;

    @Autowired
    private ReposteriaDao reposteriaDao;

    @Autowired
    private PedidoDao pedidoDao;

    @Autowired
    private OrdenDao ordenDao;

    private List<Articulo> listaArticulos = new ArrayList<>();

    @Override
    public List<Articulo> gets() {
        return listaArticulos;
    }

    @Override
    public void save(Articulo articulo) {
        for (Articulo a : listaArticulos) {
            if (Objects.equals(a.getIdPan(), articulo.getIdPan()) &&
                    Objects.equals(a.getTipo(), articulo.getTipo())) {
                a.setCantidad(a.getCantidad() + 1);
                return;
            }
        }
        listaArticulos.add(articulo);
    }

    @Override
    public void delete(Articulo articulo) {
        int posicion = -1;
        boolean existe = false;
        for (Articulo a : listaArticulos) {
            posicion++;
            if (Objects.equals(a.getIdPan(), articulo.getIdPan()) &&
                    Objects.equals(a.getTipo(), articulo.getTipo())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaArticulos.remove(posicion);
        }
    }

    @Override
    public Articulo get(Articulo articulo) {
        for (Articulo a : listaArticulos) {
            if (Objects.equals(a.getIdPan(), articulo.getIdPan()) &&
                    Objects.equals(a.getTipo(), articulo.getTipo())) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void actualiza(Articulo articulo) {
        for (Articulo a : listaArticulos) {
            if (Objects.equals(a.getIdPan(), articulo.getIdPan()) &&
                    Objects.equals(a.getTipo(), articulo.getTipo())) {
                a.setCantidad(articulo.getCantidad());
                break;
            }
        }
    }
    /*
     * @Override
     * public void Pidiendo() {
     * System.out.println("Procesando Pedido");
     * 
     * String username;
     * Object principal =
     * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     * if (principal instanceof UserDetails userDetails) {
     * username = userDetails.getUsername();
     * } else {
     * username = principal.toString();
     * }
     * 
     * if (username.isBlank()) return;
     * 
     * Usuario usuario = usuarioService.getUsuarioPorUsername(username);
     * if (usuario == null) return;
     * 
     * Pedido pedido = new Pedido(usuario.getIdUsuario());
     * pedido = pedidoDao.save(pedido);
     * 
     * double total = 0;
     * for (Articulo a : listaArticulos) {
     * System.out.println("Artículo: " + a.getDescripcion()
     * + " Cantidad: " + a.getCantidad()
     * + " Total: " + a.getPrecio() * a.getCantidad());
     * Orden orden = new Orden(pedido.getIdPedido(), a.getIdPan(), a.getPrecio(),
     * a.getCantidad(), a.getTipo());
     * ordenDao.save(orden);
     * 
     * 
     * switch (a.getTipo().toLowerCase()) {
     * case "pastel" -> {
     * var pastel = pastelDao.getReferenceById(a.getIdPan());
     * pastel.setExistencias(pastel.getExistencias() - a.getCantidad());
     * pastelDao.save(pastel);
     * }
     * case "postre" -> {
     * var postre = postreDao.getReferenceById(a.getIdPan());
     * postre.setExistencias(postre.getExistencias() - a.getCantidad());
     * postreDao.save(postre);
     * }
     * case "reposteria" -> {
     * var reposteria = reposteriaDao.getReferenceById(a.getIdPan());
     * reposteria.setExistencias(reposteria.getExistencias() - a.getCantidad());
     * reposteriaDao.save(reposteria);
     * }
     * }
     * 
     * total += a.getPrecio() * a.getCantidad();
     * }
     * 
     * pedido.setTotal(total);
     * pedidoDao.save(pedido);
     * listaArticulos.clear();
     * }
     */
}