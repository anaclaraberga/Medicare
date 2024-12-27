package br.com.start.uni_clin.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    
    @GetMapping("/public")
    public String publicEndPoint() {
        return "This is a public end-point.";
    }

    @GetMapping("/user")
    public String userEndPoint() {
        return "This is a user end-point.";
    }
}
