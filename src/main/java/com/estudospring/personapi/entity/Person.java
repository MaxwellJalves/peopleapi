package com.estudospring.personapi.entity;
import com.estudospring.personapi.dto.request.PersonDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false,unique = true)
    private String cpf;

    private LocalDate birthDate ;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private List<Phone> phone;

    public Person(PersonDto p) {
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.cpf = p.getCpf();
        this.phone = p.getPhone();
    }
}
