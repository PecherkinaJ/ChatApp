package com.MyChat.controller;

import org.springframework.web.bind.annotation.*;
import com.MyChat.repositories.UserRepository;
import com.MyChat.user.NewUser;
import com.MyChat.response.ResponseToAddUser;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseToAddUser addNewUserToDataBase(@RequestBody NewUser newUser) {
        try {
            System.out.println("email = " + newUser.getEmail());
            System.out.println("password = " + newUser.getPassword());
            System.out.println("nickname = " + newUser.getNickname());
            userRepository.storeNewUser(newUser);
            return ResponseToAddUser.of("user added");

        } catch (Exception e) {
            System.out.println("EXCEPTION WHILE POST USER!! = " + e);
            return ResponseToAddUser.of("smth went wrong; " + e);
        }
    }

    @GetMapping
    public List<NewUser> getAllUsers() {
        try {
            return userRepository.getAllUsers();
        } catch (Exception e) {
            System.out.println("EXCEPTION WHILE GET USER!! = " + e);
        }
        return null;
    }
}
