package com.au.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class CreateUserInputDTO {

    private String username;

    private String password;

}
