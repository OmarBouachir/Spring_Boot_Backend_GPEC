package com.example.demo.entity;

import lombok.Data;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Rh {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nom;

	private String prenom;

	LocalDateTime cDate;

	LocalDateTime uDate;

}
