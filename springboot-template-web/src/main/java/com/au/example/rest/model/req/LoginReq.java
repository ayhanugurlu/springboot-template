package com.au.example.rest.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {

    @ApiModelProperty(notes = "template username", required = true, example = "template")
    private String username;
    @ApiModelProperty(notes = "tempalate password", required = true, example = "pass")
    private String password;


}
