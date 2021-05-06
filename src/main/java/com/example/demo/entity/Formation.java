package com.example.demo.entity;


import com.example.demo.enums.Status;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Data
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;

	private String libelleFormation;

	private String raisonFormation;

	@Enumerated(EnumType.STRING)
	private Status status ;

	LocalDateTime cDate;

	LocalDateTime uDate;

	@ManyToOne
	private Employe employe;

}
