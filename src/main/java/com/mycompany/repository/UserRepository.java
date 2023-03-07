package com.mycompany.repository;

import com.mycompany.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Long countById(Integer id);
}
