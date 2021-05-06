package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Autorisation;

import java.util.List;

@Repository
public interface AutorisationRepository extends JpaRepository<Autorisation, Long> {
    List<Autorisation> findAllByEmployeId(Long id) ;
    void deleteAllByEmployeId(Long id) ;
}