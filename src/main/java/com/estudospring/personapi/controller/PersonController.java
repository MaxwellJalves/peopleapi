package com.estudospring.personapi.controller;

import com.estudospring.personapi.dto.request.PersonDto;
import com.estudospring.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<?> getBook(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto createdPerson(@RequestBody @Valid PersonDto p){
        return service.save(p);
    }
}
