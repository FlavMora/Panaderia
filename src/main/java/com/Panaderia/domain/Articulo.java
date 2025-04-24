
package com.Panaderia.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.io.Serializable;

@Data
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tipo;
    private Integer idPan;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String imagen;
    private int cantidad;

    private int existencias;

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
        this.existencias = pastel.getExistencias();
        this.cantidad = 1;
    }

    public Articulo(Postre postre) {
        this.tipo = "postre";
        this.idPan = postre.getId();
        this.nombre = postre.getNombre();
        this.descripcion = postre.getDescripcion();
        this.precio = postre.getPrecio();
        this.imagen = postre.getImagen();
        this.existencias = postre.getExistencias();
        this.cantidad = 1;
    }

    public Articulo(Reposteria reposteria) {
        this.tipo = "reposteria";
        this.idPan = reposteria.getId();
        this.nombre = reposteria.getNombre();
        this.descripcion = reposteria.getDescripcion();
        this.precio = reposteria.getPrecio();
        this.imagen = reposteria.getImagen();
        this.existencias = reposteria.getExistencias();
        this.cantidad = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Articulo articulo = (Articulo) o;
        return Objects.equals(idPan, articulo.idPan) && Objects.equals(tipo, articulo.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPan, tipo);
    }
}