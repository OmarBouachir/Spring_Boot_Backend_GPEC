package com.example.demo.service;

import com.example.demo.entity.Conge;
import com.example.demo.enums.Status;
import com.example.demo.repository.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class CongeService {

  @Autowired
  private CongeRepository congeRepository;

  public List<Conge> findAll() {
    return congeRepository.findAll();
  }

  public List<Conge> findAllByEmployeId(long id) {
    return congeRepository.findAllByEmployeId(id);
  }

  public Conge save(Conge conge) {
    conge.setStatus(Status.PENDING);
    conge.setCDate(now());
    return congeRepository.save(conge);
  }

  public void answer(Conge conge) {
    conge.setUDate(now());
    congeRepository.save(conge);
  }
}
