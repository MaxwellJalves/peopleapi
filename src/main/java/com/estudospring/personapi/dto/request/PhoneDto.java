package com.estudospring.personapi.dto.request;

import com.estudospring.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDto {


    private Long id;

    @NotEmpty
    @Size(min=13,max=14)
    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

}
