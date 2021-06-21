package com.estudospring.personapi.dto.request;


import com.estudospring.personapi.entity.Person;
import com.estudospring.personapi.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {


    private Long id;

    @NotEmpty
    @Size(min=2,max=100)
    private String firstName;

    @NotEmpty
    @Size(min=2,max=100)
    private String lastName;

    @NotEmpty
    private String cpf;

    private String birthDate ;

    @Valid
    @NotEmpty
    private List<Phone> phone;


//    public Person convert(PersonDto p) {
//        Person p1 =new Person();
//        p1.setFirstName(this.firstName);
//        p1.setLastName(this.lastName);
//        p1.setBirthDate(this.birthDate);
//        p1.setCpf(this.cpf);
//        p1.setPhone(this.phone);
//        return p1;
//    }
}
