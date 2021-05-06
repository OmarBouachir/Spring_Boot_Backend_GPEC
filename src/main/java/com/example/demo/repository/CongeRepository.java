package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Conge;

import java.util.List;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Long> {

  List<Conge> findAllByEmployeId(long id);

  void deleteAllByEmployeId(Long id) ;
}
