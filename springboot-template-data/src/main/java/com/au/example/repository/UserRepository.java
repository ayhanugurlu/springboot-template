package com.au.example.repository;

import com.au.example.mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Ayhan.Ugurlu
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsernameAndPassword(String firstName, String password);


    User findByUsername(String firstName);

    User save(User user);


    List<User> findAll();


}
