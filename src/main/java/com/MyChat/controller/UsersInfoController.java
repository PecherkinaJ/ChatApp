package com.MyChat.controller;

import com.MyChat.response.StatusInResponse;
import com.MyChat.user.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.MyChat.repositories.UserRepository;
import com.MyChat.user.NewUser;

@RestController
public class UsersInfoController {
    private final UserRepository userRepository;

    public UsersInfoController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public StatusInResponse addNewUserToDataBase(@RequestBody NewUser newUser) {
        try {
            System.out.println("email = " + newUser.getEmail());
            System.out.println("password = " + newUser.getPassword());
            System.out.println("nickname = " + newUser.getNickname());
            userRepository.storeNewUser(newUser);
            return StatusInResponse.of("user added");

        } catch (Exception e) {
            System.out.println("EXCEPTION WHILE POST USER!! = " + e);
            return StatusInResponse.of("smth went wrong; " + e);
        }
    }

    @GetMapping("/users")
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
                    .body(StatusInResponse.of("you don't have an access"));
        }
        return null;
    }
    @GetMapping("/users/online")
    public ResponseEntity<?> getOnlineUsers(@RequestBody Admin admin) {
        if ("admin".equals(admin.getLogin()) && "admin".equals(admin.getPassword())) {
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(userRepository.getOnlineUsers());
            } catch (Exception e) {
                System.out.println("EXCEPTION WHILE GET ONLINE USERS!! = " + e);
            }
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(StatusInResponse.of("you don't have an access"));
        }
        return null;
    }
}
