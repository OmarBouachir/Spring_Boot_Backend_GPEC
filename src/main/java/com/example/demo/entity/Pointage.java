package com.example.demo.entity;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
public class Pointage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	@Column(name="matricule")
	private String matricule;
	@Column(name="nom_prenom")
	private String nom_prenom;
	@Column(name="jour")
	private String jour;
	@Column(name="date")
	private Date date;
	@Column(name="motif")
	private String motif;
	@Column(name="HTOB")
	private float HTOB;
	@Column(name="premiere_entree_OB")
	private Time premiere_entree_OB;
	@Column(name="premiere_sortie_OB")
	private Time premiere_sortie_OB;
	@Column(name="deuxiéme_entee_OB")
	private Time deuxiéme_entee_OB;
	@Column(name="deuxiéme_sortie_OB")
	private Time deuxiéme_sortie_OB;
	@Column(name="premiere_entree")
	private Time premiere_entree;
	@Column(name="premiere_sortie")
	private Time premiere_sortie;
	@Column(name="deuxiéme_entree")
	private Time deuxiéme_entree;
	@Column(name="deuxiéme_sortie")
	private Time deuxiéme_sortie;
	@Column(name="HT_matin")
	private float HT_matin;
	@Column(name="HT_APM")
	private float HT_APM;
	@Column(name="H_CREUS")
	private float H_CREUS;
	@Column(name="H_CR_EFF")
	private float H_CR_EFF;
	@Column(name="Ecart_H_moins")
	private float Ecart_H_moins;
	@Column(name="ecart_H_plus")
	private float ecart_H_plus;
	@Column(name="TOT_H_EFF")
	private float TOT_H_EFF;
	@Column(name="TOT_ECART_moins")
	private float TOT_ECART_moins;
	@Column(name="TOT_ECART_plus")
	private float TOT_ECART_plus;
	private Date cDate;
	private Date uDate ;

	@ManyToOne
	private Archive archive;


}
