package com.example.demo.controller;

import java.util.List;

import com.example.demo.service.AutorisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Autorisation;

@RestController
@RequestMapping("/autorisation")
public class AutorisationController {

	@Autowired
	private AutorisationService autorisationService;

	@GetMapping()
	public List<Autorisation> getAll(){
		return this.autorisationService.findAll();
	}

	@GetMapping("{id}")
	public List<Autorisation> getByEmployeId(@PathVariable long id){
		return this.autorisationService.findByEmployeeId(id);
	}
	
	@PostMapping()
	public Autorisation create(@RequestBody Autorisation autorisation) {
		return this.autorisationService.save(autorisation);
	}

	@PutMapping()
	public void answer(@RequestBody Autorisation autorisation) {
		this.autorisationService.answer(autorisation) ;
	}
}
