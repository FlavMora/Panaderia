
package com.Panaderia.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import java.math.BigDecimal;


public class Articulo {
    private String tipo; // pastel, postre, reposteria
    private Long idPan;
    private String descripcion;
    private double precio;
    private int cantidad;

    public Articulo() {}

    public Articulo(Pastel pastel) {
        this.tipo = "pastel";
        this.idPan = pastel.getId();
        this.descripcion = pastel.getDescripcion();
        this.precio = pastel.getPrecio();
        this.cantidad = 1;
    }

    public Articulo(Postre postre) {
        this.tipo = "postre";
        this.idPan = postre.getId();
        this.descripcion = postre.getDescripcion();
        this.precio = postre.getPrecio();
        this.cantidad = 1;
    }

    public Articulo(Reposteria reposteria) {
        this.tipo = "reposteria";
        this.idPan = reposteria.getId();
        this.descripcion = reposteria.getDescripcion();
        this.precio = reposteria.getPrecio();
        this.cantidad = 1;
    }

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getIdPan() {
        return idPan;
    }

    public void setIdPan(Long idPan) {
        this.idPan = idPan;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
