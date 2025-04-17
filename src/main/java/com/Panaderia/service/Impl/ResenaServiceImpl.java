package com.Panaderia.service.Impl;

import com.Panaderia.dao.ResenaDao;
import com.Panaderia.service.ResenaService;
import com.Panaderia.domain.Resena;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResenaServiceImpl implements ResenaService {
    
    private final ResenaDao resenaService;

    public ResenaServiceImpl(ResenaDao resenaService) {
        this.resenaService = resenaService;
    }

    @Override
    public List<Resena> obtenerTodas() {
        return resenaService.findAllByOrderByFechaDesc();
    }

    @Override
    public Resena guardar(Resena resena) {
        if(resena.getFecha() == null) {
            resena.setFecha(LocalDateTime.now());
        }
        return resenaService.save(resena);
    }

    @Override
    public void eliminar(Integer id) {
        resenaService.deleteById(id);
    }

    @Override
    public Resena obtenerPorId(Integer id) {
        return resenaService.findById(id).orElse(null);
    }
}