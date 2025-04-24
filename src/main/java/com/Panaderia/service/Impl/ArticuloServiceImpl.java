/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Panaderia.service.Impl;

import com.Panaderia.domain.Articulo;
import com.Panaderia.service.ArticuloService;

import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Override
    public void save(Articulo articulo, List<Articulo> carrito) {
        for (Articulo a : carrito) {
            if (Objects.equals(a.getIdPan(), articulo.getIdPan()) && 
               Objects.equals(a.getTipo(), articulo.getTipo())) {
                a.setCantidad(a.getCantidad() + 1);
                return;
            }
        }
        carrito.add(articulo);
    }

    @Override
    public void delete(Articulo articulo, List<Articulo> carrito) {
        carrito.removeIf(a -> 
            Objects.equals(a.getIdPan(), articulo.getIdPan()) && 
            Objects.equals(a.getTipo(), articulo.getTipo()));
    }

    @Override
    public Articulo get(Articulo articulo, List<Articulo> carrito) {
        return carrito.stream()
            .filter(a -> 
                Objects.equals(a.getIdPan(), articulo.getIdPan()) && 
                Objects.equals(a.getTipo(), articulo.getTipo()))
            .findFirst()
            .orElse(null);
    }

    @Override
    public void actualiza(Articulo articulo, List<Articulo> carrito) {
        carrito.stream()
            .filter(a -> 
                Objects.equals(a.getIdPan(), articulo.getIdPan()) && 
                Objects.equals(a.getTipo(), articulo.getTipo()))
            .findFirst()
            .ifPresent(a -> a.setCantidad(articulo.getCantidad()));
    }
}