package com.au.example.mongo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user")
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String username;

    private String password;

}
