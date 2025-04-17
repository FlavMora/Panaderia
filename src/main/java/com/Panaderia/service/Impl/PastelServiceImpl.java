package com.Panaderia.service.Impl;

import com.Panaderia.domain.Pastel;
import com.Panaderia.dao.PastelDao;
import com.Panaderia.service.PastelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;



@Service
public class PastelServiceImpl implements PastelService {

  private final PastelDao pastelRepository;

  public PastelServiceImpl(PastelDao pastelRepository) {
    this.pastelRepository = pastelRepository;
  }

  @Override
  public List<Pastel> findAll() {
    return pastelRepository.findAll();
  }

  @Override
  public Optional<Pastel> findById(Integer id) {
    return pastelRepository.findById(id);
  }

  @Override
  public Pastel save(Pastel pastel) {
    return pastelRepository.save(pastel);
  }

  @Override
  public void deleteById(Integer id) {
    pastelRepository.deleteById(id);
  }
  
   //
   @Override
   @Transactional(readOnly=true)
   public List<Pastel>findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
        return pastelRepository.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    
    
}
