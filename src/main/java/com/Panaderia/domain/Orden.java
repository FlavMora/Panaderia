package com.Panaderia.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orden")
public class Orden implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Integer idOrden;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;
    @Column(name = "id_reposterias")
    private Integer idReposterias;
    @Column(name = "id_postres")
    private Integer idPostres;
    @Column(name = "id_pasteles")
    private Integer idPasteles;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;
    @Column(nullable = false)
    private Integer cantidad;

    public Orden() {
        // Constructor por defecto
    }

    public Orden(Pedido pedido,
            Integer idReposterias,
            Integer idPostres,
            Integer idPasteles,
            BigDecimal precio,
            Integer cantidad) {
        this.pedido = pedido;
        this.idReposterias = idReposterias;
        this.idPostres = idPostres;
        this.idPasteles = idPasteles;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}
