/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Panaderia.dao;

import com.Panaderia.domain.Pastel;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PastelDao extends JpaRepository<Pastel, Integer> {
  public List<Pastel> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}
