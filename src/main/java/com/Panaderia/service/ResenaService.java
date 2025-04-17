package com.Panaderia.service;

import com.Panaderia.domain.Resena;
import java.util.List;

public interface ResenaService {
    List<Resena> obtenerTodas();
    Resena guardar(Resena resena);
    void eliminar(Integer id);
    Resena obtenerPorId(Integer id);
}
