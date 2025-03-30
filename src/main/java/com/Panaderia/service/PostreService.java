package com.Panaderia.service;

import com.Panaderia.domain.Postre;
import java.util.List;
import java.util.Optional;

public interface PostreService {
  List<Postre> findAll();

  Optional<Postre> findById(Integer id);

  Postre save(Postre postre);

  void deleteById(Integer id);
}
