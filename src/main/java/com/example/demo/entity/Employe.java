package com.example.demo.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Data
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nom;

	private String prenom;

	private String matricule;

	private String dateLieuNaissance;

	private String nationnalite;

	private String etatCivil;

	private int nombreEnfant;

	private String adresse;

	private int cin;

	private int tel;

	private LocalDate delivreLe;

	private int numeroCnss;

	private int numeroPermisConduire;

	private String categoriePermis;

	private String niveauInstruction;

	private String diplome;

	private String anneeDiplome;

	private String etablissement;

	private LocalDate dateEmbauche;

	private String typeContrat;

	private LocalDate debutContrat;

	private LocalDate finContrat;

	private float salaireNet;

	private String qualification;

	private LocalDate dateDebutQualification;

	private String affectation;

	private String departement;

	private String section;

	private LocalDate dateTitularisation;

	private String competenceAcademique;

	private boolean acces = true ;

	private LocalDateTime cDate;

	private LocalDateTime uDate;

	@ManyToMany(cascade = CascadeType.ALL)
	List<Projet> projets = new ArrayList<>();

//	//liaison avec archive
//	@ManyToOne
//	private Archive archiv;
}
