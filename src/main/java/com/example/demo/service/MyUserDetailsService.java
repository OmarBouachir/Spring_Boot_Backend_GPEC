package com.example.demo.service;

import com.example.demo.entity.MyUserDetails;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public MyUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(s);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + s));
        return user.map(MyUserDetails::new).get();
    }

}
