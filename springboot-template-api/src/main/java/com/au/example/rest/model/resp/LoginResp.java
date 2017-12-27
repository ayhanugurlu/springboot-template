package com.au.example.rest.model.resp;

import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author Ayhan.Ugurlu
 */
@Setter
@NoArgsConstructor
public class LoginResp {

    private String firstName;

    private String lastName;

    private String token;

}
