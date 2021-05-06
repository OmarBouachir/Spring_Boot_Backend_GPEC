package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest implements Serializable {


    private String username;
    private String password;

    //need default constructor for JSON Parsing
//    public AuthenticationRequest()
//    {}
//
//    public AuthenticationRequest(String username, String password) {
//        this.setUsername(username);
//        this.setPassword(password);
//    }
}
