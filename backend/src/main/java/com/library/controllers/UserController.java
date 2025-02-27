package com.library.controllers;
import com.library.model.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/")
    public User getUserByName(@RequestParam("name") String name, @RequestParam ("lastname") String lastname) {
        return userService.findByName(name, lastname);
    }
    @GetMapping("/all")
    public List <User> getAll(){
        return userService.getAllUser();
    }
    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @DeleteMapping("/")
    public void deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
    }
}
