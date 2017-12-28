package com.au.example.repository;

import com.au.example.common.SessionState;
import com.au.example.mongo.UserSession;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ayhan.Ugurlu
 */
public interface UserSessionRepository extends MongoRepository<UserSession, String> {

    UserSession findByUserIdAndSessionState(String userId, SessionState sessionState);

    UserSession save(UserSession userSession);

}
