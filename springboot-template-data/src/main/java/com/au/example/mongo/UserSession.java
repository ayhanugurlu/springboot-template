package com.au.example.mongo;


import com.au.example.common.SessionState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userSession")
@Setter
@Getter
@NoArgsConstructor
public class UserSession {

    @Id
    private String id;

    private String userId;

    private String token;

    private SessionState sessionState;

}