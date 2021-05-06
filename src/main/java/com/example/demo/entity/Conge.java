package com.example.demo.entity;

import com.example.demo.enums.Status;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
public class Conge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nature;

	private String nbJour;

	private String dateDebut;

	private String dateFin;

	private String adresseDurantConge;

	private LocalDateTime cDate ;

	private LocalDateTime uDate ;

	@Enumerated(EnumType.STRING)
	private Status status ;

	@ManyToOne
	private Employe employe;

//	@ManyToOne
//	private Archive archive;

//	private String Qualification_demandeur;

//	private String RepriseLe;

}
