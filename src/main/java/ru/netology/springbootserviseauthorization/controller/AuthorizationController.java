package ru.netology.springbootserviseauthorization.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootserviseauthorization.domain.Person;
import ru.netology.springbootserviseauthorization.model.Authorities;
import ru.netology.springbootserviseauthorization.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Validated Person person) {
        return service.getAuthorities(person.getUserName(), person.getUserPassword());
    }
}