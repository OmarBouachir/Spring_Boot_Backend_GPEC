package com.example.demo.entity;

import com.example.demo.enums.Status;
import lombok.Data;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Data
public class Autorisation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;

	private String dateAutorisation;

	private String raissonAutorisation;

	private LocalDateTime cDate ;

	private LocalDateTime uDate;

	@Enumerated(EnumType.STRING)
	private Status status ;

	@ManyToOne
	private Employe employe;
}
