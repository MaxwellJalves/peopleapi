package com.estudospring.personapi.controller;

import com.estudospring.personapi.dto.MessageDTO;
import com.estudospring.personapi.entity.Person;
import com.estudospring.personapi.entity.Phone;
import com.estudospring.personapi.enums.PhoneType;
import com.estudospring.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    @GetMapping
    public ResponseEntity<?> getBook(){
        return ResponseEntity.ok().body(personRepo.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageDTO createdPerson(@RequestBody Person p){
      Person person =   personRepo.save(p);
        return  MessageDTO
                .builder()
                .message("Sucesso"+person)
                .build();
    }
}
