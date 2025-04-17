package com.Panaderia.service;

import com.Panaderia.domain.Reposteria;
import java.util.List;
import java.util.Optional;

public interface ReposteriaService {
  List<Reposteria> findAll();

  Optional<Reposteria> findById(Integer id);

  Reposteria save(Reposteria reposteria);

  void deleteById(Integer id);
  public List<Reposteria>findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}

