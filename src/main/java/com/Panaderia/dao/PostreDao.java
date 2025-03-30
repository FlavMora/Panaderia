package com.Panaderia.dao;

import com.Panaderia.domain.Postre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostreDao extends JpaRepository<Postre, Integer> {
}
