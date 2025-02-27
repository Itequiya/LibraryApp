package com.library.service;
import com.library.model.User;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User findByName(String name, String lastname){
        return  userRepository.findByName(name, lastname);
    }
    public User addUser(User user){
        return  userRepository.addUser(user);
    }

    public void deleteUser (Long id){
        userRepository.deleteUser(id);
    }
}
