package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private boolean active;

    private String roles;

    @OneToOne
    private Employe employe ;

    @OneToOne
    private Rh rh ;

}
