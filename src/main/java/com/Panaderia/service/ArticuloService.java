
package com.Panaderia.service;
import com.Panaderia.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    Articulo get(Articulo articulo, List<Articulo> carrito);
    void delete(Articulo articulo, List<Articulo> carrito);
    void save(Articulo articulo, List<Articulo> carrito);
    void actualiza(Articulo articulo, List<Articulo> carrito);
}
