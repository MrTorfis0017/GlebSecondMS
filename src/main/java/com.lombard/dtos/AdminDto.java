package com.lombard.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AdminDto {

    private Long id;

    private String firstName;

    private String lastName;
}
