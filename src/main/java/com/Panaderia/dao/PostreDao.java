package com.Panaderia.dao;

import com.Panaderia.domain.Postre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PostreDao extends JpaRepository<Postre, Integer> {
     public List<Postre>findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}
