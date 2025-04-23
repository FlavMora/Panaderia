
package com.Panaderia.domain;

import java.math.BigDecimal;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="orden")
public class Orden implements Serializable {    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_orden")
    private Integer idOrden;
    private Integer idPedido;
    private Integer idReposterias; 
    private Integer idPostres;
    private Integer idPasteles; 
    private double precio;
    private int cantidad;    
    
    public Orden() {
    }

    public Orden(Integer idPedido, Integer idReposterias,Integer idPostres,Integer idPasteles, double precio, int cantidad) {
        this.idPedido = idPedido;
        this.idReposterias = idReposterias;
        this.idPostres = idPostres;
        this.idPasteles = idPasteles;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}