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
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Panaderia.dao.ReposteriaDao;
import com.Panaderia.dao.PastelDao;
import com.Panaderia.dao.PostreDao;

public class ArticuloServiceImpl implements ArticuloService {
    
     @Override
    public Articulo get(Articulo articulo) {
    // Implementación que busca por tipo y idProducto
    return articuloRepository.findByTipoAndIdProducto(articulo.getTipo(), articulo.getIdPan());
}

public void delete(Articulo articulo) {
    // Implementación que elimina por tipo y idProducto
    Articulo existingArticulo = findByTipoAndIdProducto(articulo.getTipo(), articulo.getIdPan());
    if (existingArticulo != null) {
        articuloRepository.delete(existingArticulo);
    }
}

}
