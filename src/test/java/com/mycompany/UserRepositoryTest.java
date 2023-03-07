package com.mycompany;

import com.mycompany.models.User;
import com.mycompany.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
//    @Autowired
//    private UserRepository repository;
//
//    @Test
//    public void testAddNew(){
//        User user = new User();
//        user.setEmail("pntnoah@gmail.com");
//        user.setPassword("123456");
//        user.setFirstName("pham");
//        user.setLastName("thang");
//
//        User usersaved =  repository.save(user);
//    }
//
//    @Test
//    public void testListAll(){
//        List<User> list = repository.findAll();
//        System.out.println(list);
//    }
//
//    @Test
//    public void testUpdate() {
//        Optional<User> optionalUser = repository.findById(1);
//        User us = optionalUser.get();
//        System.out.println(us);
//    }
}
