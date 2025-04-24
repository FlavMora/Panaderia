package com.Panaderia.service.Impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Panaderia.dao.FacturaDao;
import com.Panaderia.domain.Factura;
import com.Panaderia.service.FacturaService;
import com.Panaderia.domain.Articulo;
import com.Panaderia.domain.DetalleFactura;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaDao facturaRepo;

    @Override
    public Factura crearFactura(List<Articulo> carrito) {
        Factura factura = new Factura();
        factura.setFecha(LocalDateTime.now());

        List<DetalleFactura> detalles = carrito.stream().map(item -> {
            DetalleFactura d = new DetalleFactura();
            d.setDescripcion(item.getDescripcion());
            d.setPrecioUnitario(item.getPrecio());
            d.setCantidad(item.getCantidad());
            d.setSubtotal(item.getPrecio().multiply(BigDecimal.valueOf(item.getCantidad())));
            d.setFactura(factura);
            return d;
        }).toList();

        factura.setDetalles(detalles);
        factura.setTotal(detalles.stream()
                .map(DetalleFactura::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add));

        return facturaRepo.save(factura);
    }
}
