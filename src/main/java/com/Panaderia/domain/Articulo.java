
package com.Panaderia.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import java.math.BigDecimal;


@Data
public class Articulo {
    private String tipo;     // pastel, postre, reposteria
    private Integer idPan;      // id del elemento (pastel, postre, o reposteria)
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String imagen;
    private int cantidad;

    public Articulo() {
        this.cantidad = 1;
    }

    public Articulo(Pastel pastel) {
        this.tipo = "pastel";
        this.idPan = pastel.getId();
        this.nombre = pastel.getNombre();
        this.descripcion = pastel.getDescripcion();
        this.precio = pastel.getPrecio();
        this.imagen = pastel.getImagen();
        this.cantidad = 1;
    }

    public Articulo(Postre postre) {
        this.tipo = "postre";
        this.idPan = postre.getId();
        this.nombre = postre.getNombre();
        this.descripcion = postre.getDescripcion();
        this.precio = postre.getPrecio();
        this.imagen = postre.getImagen();
        this.cantidad = 1;
    }

    public Articulo(Reposteria reposteria) {
        this.tipo = "reposteria";
        this.idPan = reposteria.getId();
        this.nombre = reposteria.getNombre();
        this.descripcion = reposteria.getDescripcion();
        this.precio = reposteria.getPrecio();
        this.imagen = reposteria.getImagen();
        this.cantidad = 1;
    }
}