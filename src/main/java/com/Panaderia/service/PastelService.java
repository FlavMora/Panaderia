/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Panaderia.service;

import com.Panaderia.domain.Pastel;
import java.util.List;
import java.util.Optional;

public interface PastelService {
 List<Pastel> findAll();

 Optional<Pastel> findById(Integer id);

 Pastel save(Pastel pastel);

  void deleteById(Integer id);
}
