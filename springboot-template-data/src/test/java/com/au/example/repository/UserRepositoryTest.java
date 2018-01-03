package com.au.example.repository;

import com.au.example.mongo.User;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.assertj.core.api.Assertions;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb.InMemoryMongoRuleBuilder.newInMemoryMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @ClassRule
    public static InMemoryMongoDb inMemoryMongoDb = newInMemoryMongoDbRule().build();

    @Rule
    public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("demo-test");

    /**
     * nosql-unit requirement
     */
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    UserRepository userRepository;

    @Test
    @UsingDataSet(locations = {"/users.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void testFindByUsername() {
        User user = this.userRepository.findByUsername("test");
        Assertions.assertThat(user.getUsername()).isEqualTo("test");
    }


    @Test
    @UsingDataSet(locations = {"/users.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void testFindByUsernameAndPassword() {
        User user = this.userRepository.findByUsernameAndPassword("test","pass");
        Assertions.assertThat(user.getUsername()).isEqualTo("test");
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setPassword("pass");
        user.setUsername("test");
        this.userRepository.save(user);
        Assertions.assertThat(user.getId()).isNotEmpty();
    }

    @Test
    @UsingDataSet(locations = {"/users.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void testFindAll() {
        int size = this.userRepository.findAll().size();
        Assertions.assertThat(size).isEqualTo(2);
    }
}
