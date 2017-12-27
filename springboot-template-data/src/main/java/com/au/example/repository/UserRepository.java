package com.au.example.repository;

import com.au.example.mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ayhan.Ugurlu
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsernameAndPassword(String firstName,String password);

    User save(User user);

}
