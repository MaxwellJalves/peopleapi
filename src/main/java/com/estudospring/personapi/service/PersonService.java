package com.estudospring.personapi.service;


import com.estudospring.personapi.dto.request.PersonDto;
import com.estudospring.personapi.entity.Person;
import com.estudospring.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepo;

    public PersonDto save(PersonDto p) {
        Person p1 = new Person(p);

        personRepo.save(p1);
       return  PersonDto.builder()
               .id(p1.getId())
               .firstName(p1.getFirstName())
               .lastName(p1.getLastName())
               .cpf(p1.getCpf())
               .birthDate("2020-01-01")
               .phone(p1.getPhone())
        .build();

    }

    public Object findAll() {
        return personRepo.findAll();
    }
}


