package com.Panaderia.dao;

import com.Panaderia.domain.Reposteria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ReposteriaDao extends JpaRepository<Reposteria, Integer> {
public List<Reposteria>findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}
