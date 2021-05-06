package com.example.demo.entity;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
public class Projet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String libelle;

	private LocalDate dateDebut;

	private LocalDate dateFin;

	private String competenceAjoutee;

	LocalDateTime cDate;

	LocalDateTime uDate;

}
