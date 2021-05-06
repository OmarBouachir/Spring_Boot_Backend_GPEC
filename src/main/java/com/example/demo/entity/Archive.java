package com.example.demo.entity;

import lombok.Data;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Archive {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date cDate;
	private Date uDate;
	
}
