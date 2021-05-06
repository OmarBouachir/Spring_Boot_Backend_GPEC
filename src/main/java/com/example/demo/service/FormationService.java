package com.example.demo.service;

import com.example.demo.entity.Formation;
import com.example.demo.enums.Status;
import com.example.demo.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class FormationService {

    @Autowired
    private FormationRepository formationRepository ;

    public List<Formation> findAll() {
        return formationRepository.findAll() ;
    }

    public List<Formation> findAllByEmployeId(long id) {
        return formationRepository.findAllByEmployeId(id);
    }

    public Formation save(Formation formation) {
        formation.setStatus(Status.PENDING);
        formation.setCDate(now());
        return formationRepository.save(formation) ;
    }

    public void answer(Formation formation) {
        formation.setUDate(now());
        formationRepository.save(formation);
    }
}
