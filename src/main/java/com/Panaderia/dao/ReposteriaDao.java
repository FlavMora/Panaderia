package com.Panaderia.dao;

import com.Panaderia.domain.Reposeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReposeriaDao extends JpaRepository<Reposeria, Integer> {
}
