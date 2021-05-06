package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender javaMailSender ;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender ;
    }

    public void sendMail(User user ) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage() ;
        mail.setFrom("smartechnologyGpec@gmail.com");
        mail.setTo(user.getEmail());
        mail.setSubject("Mot de passe compte GPEC");
        mail.setText("Your Password : " + user.getPassword());
        javaMailSender.send(mail);
    }

}
