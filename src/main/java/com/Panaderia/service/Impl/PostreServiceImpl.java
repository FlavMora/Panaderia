package com.Panaderia.service.Impl;

import com.Panaderia.domain.Postre;
import com.Panaderia.dao.PostreDao;
import com.Panaderia.service.PostreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostreServiceImpl implements PostreService {

  private final PostreDao postreRepository;

  public PostreServiceImpl(PostreDao postreRepository) {
    this.postreRepository = postreRepository;
  }

  @Override
  public List<Postre> findAll() {
    return postreRepository.findAll();
  }

  @Override
  public Optional<Postre> findById(Integer id) {
    return postreRepository.findById(id);
  }

  @Override
  public Postre save(Postre postre) {
    return postreRepository.save(postre);
  }

  @Override
  public void deleteById(Integer id) {
    postreRepository.deleteById(id);
  }
}
