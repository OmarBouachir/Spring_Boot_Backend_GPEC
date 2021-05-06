package com.example.demo.controller;

import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.entity.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService ;

    @PostMapping(value = "/signup")
    public User postAuthData(@RequestBody User user){
        return this.authService.signup(user) ;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        return this.authService.login(authenticationRequest) ;
    }

}
