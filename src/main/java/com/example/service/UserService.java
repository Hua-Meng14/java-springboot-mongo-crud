package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private  final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user");
        }
    }

    public User updateUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update user");
        }
    }

    public List<User> getAllUsers(){
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve users");
        }
    }

    public User getUserById(String id) {
        try{
            return userRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("User not found"));
        } catch (NoSuchElementException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve user");
        }
    }

    public  void  deleteUser(String id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException("User not found");
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete user");
        }
    }
}
