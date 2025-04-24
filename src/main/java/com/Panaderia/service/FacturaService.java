package com.Panaderia.service;

import java.util.List;

import com.Panaderia.domain.Articulo;
import com.Panaderia.domain.Factura;

public interface FacturaService {
  Factura crearFactura(List<Articulo> carrito);
}