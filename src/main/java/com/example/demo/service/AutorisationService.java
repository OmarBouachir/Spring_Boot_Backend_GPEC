package com.example.demo.service;

import com.example.demo.entity.Autorisation;
import com.example.demo.entity.Employe;
import com.example.demo.enums.Status;
import com.example.demo.repository.AutorisationRepository;
import com.example.demo.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class AutorisationService {

  @Autowired
  private AutorisationRepository autorisationRepository;

  @Autowired
  private EmployeRepository employeRepository ;


  public List<Autorisation> findAll() {
    return autorisationRepository.findAll();
  }

  public Autorisation save(Autorisation autorisation) {
    autorisation.setStatus(Status.PENDING);
    autorisation.setCDate(now());
    return autorisationRepository.save(autorisation);
  }

  public void answer(Autorisation autorisation) {
    autorisation.setUDate(now());
    this.autorisationRepository.save(autorisation);
  }

  public List<Autorisation> findByEmployeeId(Long id) {
    return this.autorisationRepository.findAllByEmployeId(id);
  }
}
