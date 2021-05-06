package com.example.demo.service;

import com.example.demo.config.JwtUtil;
import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.entity.Employe;
import com.example.demo.entity.MyUserDetails;
import com.example.demo.entity.Rh;
import com.example.demo.entity.User;
import com.example.demo.repository.EmployeRepository;
import com.example.demo.repository.RhRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static java.time.LocalDateTime.now;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeRepository employeRepository ;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private MailService mailService ;

    @Autowired
    private RhRepository rhRepository;

    @Transactional
    public User signup(User user) {
        // save employee
        if(user.getEmploye() != null) {
            user.getEmploye().setCDate(now());
            Employe employe = employeRepository.save(user.getEmploye());
            user.setEmploye(employe);
        }
        else if (user.getRh() != null){
            user.getRh().setCDate(now());
            Rh rh = rhRepository.save(user.getRh()) ;
            user.setRh(rh);
        }
        // Set password and send mail
        user.setPassword(generateRandomPassword(10,'0','z'));
        try {
            this.mailService.sendMail(user);
        }catch (Exception e) {
            System.out.println(e);
        }

        //save and return user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRoles("employe");
        return userRepository.save(user);
    }

    public static String generateRandomPassword(int len, int randNumOrigin, int randNumBound)
    {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange(randNumOrigin, randNumBound)
                .filteredBy(CharacterPredicates.ASCII_ALPHA_NUMERALS)
                .build();

        return generator.generate(len);
    }

    public ResponseEntity<?> login(AuthenticationRequest authenticationRequest) throws Exception {
        User user = userRepository.findByEmail(authenticationRequest.getUsername()).orElseThrow(IllegalArgumentException::new) ;
        try {
            Authentication a = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final MyUserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        if(user.getEmploye() != null){
            return ResponseEntity.ok(new AuthenticationResponse(jwt ,  user.getEmploye().getId()  , user.getRoles()));
        }
        return ResponseEntity.ok(new AuthenticationResponse(jwt , user.getRh().getId()  , user.getRoles()));
    }
}
