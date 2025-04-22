
package com.Panaderia.service;
import com.Panaderia.domain.Articulo;
import java.util.ArrayList;
import java.util.List;

public interface ArticuloService {
   List<Articulo> listaArticulos = new ArrayList<>();
    
    public List<Articulo> gets();
    
    public Articulo get(Articulo articulo);
    

    public void delete(Articulo articulo);
    
    
    public void save(Articulo articulo);
    
    public void actualiza(Articulo articulo);
    
    public void Pidiendo();
}
