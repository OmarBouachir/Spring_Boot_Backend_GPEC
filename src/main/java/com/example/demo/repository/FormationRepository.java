package com.example.demo.repository;

import com.example.demo.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

  List<Formation> findAllByEmployeId(long id);
  void deleteAllByEmployeId(Long id) ;
}
