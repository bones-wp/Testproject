package com.aston.internship.controller;

import com.aston.internship.entity.Details;
import com.aston.internship.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/register")
public class RegistrationController {

    private DetailsRepository detailsRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(
            DetailsRepository detailsRepository, PasswordEncoder passwordEncoder) {
        this.detailsRepository = detailsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<?> registration (@RequestParam("name") String name, @RequestParam("surname") String surname,
                                           @RequestParam("login") String login, @RequestParam("password") String password,
                                           @RequestParam("phone") String phone, @RequestParam("email") String email){
        Details details = new Details();
        details.setName(name);
        details.setSurname(surname);
        details.setUsername(login);
        details.setPassword(passwordEncoder.encode(password));
        details.setPhone(phone);
        details.setEmail(email);

        detailsRepository.save(details);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
