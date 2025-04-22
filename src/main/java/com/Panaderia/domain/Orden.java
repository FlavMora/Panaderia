
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
    private Long idOrden;
    private Long idPedido;
    private Long idReposterias; 
    private Long idPostres;
    private Long idPasteles; 
    private double precio;
    private int cantidad;    
    
    public Orden() {
    }

    public Orden(Long idPedido, Long idReposterias,Long idPostres,Long idPasteles, double precio, int cantidad) {
        this.idPedido = idPedido;
        this.idReposterias = idReposterias;
        this.idPostres = idPostress;
        this.idPasteles = idPasteles;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}