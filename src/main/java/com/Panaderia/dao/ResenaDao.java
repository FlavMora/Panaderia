package com.Panaderia.dao;

import com.Panaderia.domain.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResenaDao extends JpaRepository<Resena, Integer> {
  List<Resena> findAllByOrderByFechaDesc();
}
