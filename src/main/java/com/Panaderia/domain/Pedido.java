package com.Panaderia.domain;
import jakarta.persistence.*;
import java.math.BigDecimal;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="pedido")
public class Pedido implements Serializable {    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private Long idPedido;
    private Long idUsuario;
    private Date fecha;
    private double total;
    private int estado;
    
    
    public Pedido() {
    }

    public Pedido(Long idUSuario) {
        this.idUsuario = idUSuario;
        this.fecha = Calendar.getInstance().getTime();
        this.estado=1;
    }    
}