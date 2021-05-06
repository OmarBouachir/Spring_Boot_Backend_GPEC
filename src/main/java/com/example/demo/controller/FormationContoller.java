package com.example.demo.controller;

import java.util.List;


import com.example.demo.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Formation;

@RestController
@RequestMapping("/formation")

public class FormationContoller {

	@Autowired
	private FormationService formationService;

	@GetMapping()
	public List<Formation> getAll(){
		return this.formationService.findAll();
	}

	@GetMapping("{id}")
	public List<Formation> getByEmployeId(@PathVariable long id) {
		return this.formationService.findAllByEmployeId(id);
	}

	@PostMapping()
	public Formation create(@RequestBody Formation formation) {
		return this.formationService.save(formation);
	}

	@PutMapping()
	public void answer(@RequestBody Formation formation) {
		this.formationService.answer(formation) ;
	}

}
