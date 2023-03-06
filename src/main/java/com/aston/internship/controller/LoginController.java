package com.aston.internship.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {

    @GetMapping(value = "/login")
    public String home(Principal principal) {
        return "Hello, " + principal.getName();
    }

    @PreAuthorize("hasRole('SCOPE_read')")
    @GetMapping(value = "/secure")
    public String secure() {
        return "This is secured!";
    }

}
