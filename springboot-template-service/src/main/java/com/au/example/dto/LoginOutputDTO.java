package com.au.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LoginOutputDTO {

    private String userId;

    private String userSessionId;
}
