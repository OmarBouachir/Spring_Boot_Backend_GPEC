package com.example.demo.controller;


import com.example.demo.entity.Employe;
import com.example.demo.entity.Projet;
import com.example.demo.service.EmployeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employes")
public class EmployeController {
	
	@Autowired
	private EmployeService employeService ;
	
	@GetMapping()
	public List<Employe> getAll(){
		return employeService.findAll();
	}

	@GetMapping("/name/{prenom}")
	public List<Employe> findByprenom(@PathVariable String prenom){
		return employeService.findByprenom(prenom);
	}




	@GetMapping("/projet/{id}")
	public List<Projet> getProjetsByEmployeId(@PathVariable long id) throws NotFoundException {
		return employeService.getProjetsByEmployeId(id);
	}

	@GetMapping("/projet")
	public List<Projet> getProjets(){
		return employeService.getProjets();
	}

	@PostMapping()
	public Employe createEmploye(@RequestBody Employe employe) {
		return employeService.save(employe);
	}

	@PostMapping("/projet/{id}")
	public void addProject(@RequestBody Projet projet, @PathVariable long id) throws NotFoundException {
		employeService.addProject(projet, id);
	}

	@PutMapping()
	public Employe updateEmploye(@RequestBody Employe employe) {
		return employeService.update(employe);
	}

	@DeleteMapping("/{id}")
	public void deletEmploye(@PathVariable("id") long id){
		employeService.delete(id) ;
	}

}
