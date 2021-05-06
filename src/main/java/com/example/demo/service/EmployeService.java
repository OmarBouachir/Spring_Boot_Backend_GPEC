package com.example.demo.service;


import com.example.demo.entity.Employe;
import com.example.demo.entity.Projet;
import com.example.demo.repository.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private CongeRepository congeRepository ;

    @Autowired
    private AutorisationRepository autorisationRepository ;

    @Autowired
    private FormationRepository formationRepository ;
    
    @Autowired
    private UserRepository userRepository;

    public List<Employe> findAll() {
        return employeRepository.findAll() ;
    }


    

    public Employe save(Employe employe) {
        return employeRepository.save(employe) ;
    }

    public Employe update(Employe employe) {
        return employeRepository.save(employe) ;
    }

    public List<Projet> getProjetsByEmployeId(long id) throws NotFoundException {
        Employe employe = employeRepository.findById(id)
            .orElseThrow(()->{ return new NotFoundException("Not Found");});
        return employe.getProjets();
    }

    public List<Projet> getProjets() {
        return projetRepository.findAll();
    }


    public void addProject(Projet projet, long id) throws NotFoundException {
        Employe employe = employeRepository.findById(id)
            .orElseThrow(()->{ return new NotFoundException("Not Found");});
        Projet p = projetRepository.save(projet);
        List<Projet> projets = employe.getProjets();
        projets.add(p);
        employe.setProjets(projets);
        employeRepository.save(employe);
    }

    @Transactional
    public void delete(long id) {
        this.formationRepository.deleteAllByEmployeId(id);
        this.autorisationRepository.deleteAllByEmployeId(id);
        this.congeRepository.deleteAllByEmployeId(id);
        this.userRepository.deleteByEmployeId(id) ;
        this.employeRepository.deleteById(id);
    }

    public List<Employe> findByprenom(String prenom) {
        return  employeRepository.findByPrenom(prenom);
     }
}
