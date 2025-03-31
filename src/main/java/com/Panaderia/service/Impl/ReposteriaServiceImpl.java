package com.Panaderia.service.Impl;

import com.Panaderia.domain.Reposteria;
import com.Panaderia.dao.ReposteriaDao;
import com.Panaderia.service.ReposteriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReposteriaServiceImpl implements ReposteriaService {

  private final ReposteriaDao reposteriaRepository;

  public ReposteriaServiceImpl(ReposteriaDao reposteriaRepository) {
    this.reposteriaRepository = reposteriaRepository;
  }

  @Override
  public List<Reposteria> findAll() {
    return reposteriaRepository.findAll();
  }

  @Override
  public Optional<Reposteria> findById(Integer id) {
    return reposteriaRepository.findById(id);
  }

  @Override
  public Reposteria save(Reposteria reposteria) {
    return reposteriaRepository.save(reposteria);
  }

  @Override
  public void deleteById(Integer id) {
    reposteriaRepository.deleteById(id);
  }
}

