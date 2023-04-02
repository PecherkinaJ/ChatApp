package com.MyChat.controller;

import org.springframework.web.bind.annotation.*;
import com.MyChat.repositories.UserRepository;
import com.MyChat.user.NewUser;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public void addNewUserToDataBase(@RequestBody NewUser newUser) {
        try {
            userRepository.storeNewUser(newUser);
        } catch (Exception e) {
            System.out.println("EXCEPTION!! = " + e);
        }
    }

    @GetMapping
    public List<NewUser> getAllUsers() {
        try {
            return userRepository.getAllUsers();
        } catch (Exception e) {
            System.out.println("EXCEPTION!! = " + e);
        }
        return null;
    }
}
