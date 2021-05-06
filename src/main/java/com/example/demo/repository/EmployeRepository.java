package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employe;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>  {

     List<Employe> findByPrenom(String prenom);


}
