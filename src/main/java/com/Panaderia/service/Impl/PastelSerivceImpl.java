/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Panaderia.service.Impl;

import com.Panaderia.domain.Pastel;
import com.Panaderia.dao.PasteleDao;
import com.Panaderia.service.PastelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PestelServiceImpl implements PastelService {

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
  public Postre save(Pastel pastel) {
    return pastelRepository.save(pastel);
  }

  @Override
  public void deleteById(Integer id) {
    pastelRepository.deleteById(id);
  }
}
