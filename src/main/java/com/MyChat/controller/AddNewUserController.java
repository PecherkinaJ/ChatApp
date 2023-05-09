package com.MyChat.controller;

import com.MyChat.user.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.MyChat.repositories.UserRepository;
import com.MyChat.user.NewUser;
import com.MyChat.response.ResponseToAddUser;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/users")
@RestController
public class AddNewUserController {
    private final UserRepository userRepository;

    public AddNewUserController(UserRepository userRepository) {
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
    public ResponseEntity<?> getAllUsers(@RequestBody Admin admin) {
        if ("admin".equals(admin.getLogin()) && "admin".equals(admin.getPassword())) {
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(userRepository.getAllUsers());
            } catch (Exception e) {
                System.out.println("EXCEPTION WHILE GET USER!! = " + e);
            }
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(ResponseToAddUser.of("you don't have an access"));
        }
        return null;
    }
}
