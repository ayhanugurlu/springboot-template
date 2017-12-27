package com.au.example.rest.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@NoArgsConstructor
public class LoginReq {

    private String username;

    private String password;


    @ApiModelProperty(notes = "template username", required = true, example = "template")
    public String getUsername() {
        return username;
    }


    @ApiModelProperty(notes = "tempalate password", required = true, example = "pass")
    public String getPassword() {
        return password;
    }


}
