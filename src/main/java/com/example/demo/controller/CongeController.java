package com.example.demo.controller;

import java.util.List;

import com.example.demo.service.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Conge;

@RestController
@RequestMapping("/conges")
public class CongeController {

  @Autowired
  private CongeService congeService;

  @GetMapping()
  public List<Conge> getAll() {
    return this.congeService.findAll();
  }

  @GetMapping("{id}")
  public List<Conge> getByEmployeId(@PathVariable long id) {
    return this.congeService.findAllByEmployeId(id);
  }

  @PostMapping()
  public Conge create(@RequestBody Conge conge) {
    return this.congeService.save(conge);
  }

  @PutMapping()
  public void answer(@RequestBody Conge conge) {
    this.congeService.answer(conge);
  }

}
