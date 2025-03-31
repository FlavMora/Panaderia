package com.Panaderia.dao;

import com.Panaderia.domain.Reposteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReposteriaDao extends JpaRepository<Reposteria, Integer> {
}
