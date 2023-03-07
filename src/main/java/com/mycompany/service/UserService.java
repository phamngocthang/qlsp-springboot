package com.mycompany.service;

import com.mycompany.models.User;
import com.mycompany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public List<User> listAll() {
        return repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }
    public User getById(Integer id) throws UserNotFoundException{
        Optional<User> result = repo.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID" + id);
    }

    public void deleteById(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if(count == null || count == 0) {
            throw new UserNotFoundException("Could not find any users with ID" + id);
        }
        repo.deleteById(id);
    }
}
