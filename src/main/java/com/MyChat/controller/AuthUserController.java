package com.MyChat.controller;

import com.MyChat.repositories.UserRepository;
import com.MyChat.response.ResponseToAddUser;
import com.MyChat.user.AuthUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthUserController {

    private final UserRepository userRepository;

    public AuthUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseToAddUser authUser(@RequestBody AuthUser user) {
        try {
            boolean result = userRepository.authUser(user);
            if (result) return ResponseToAddUser.of("user authorized" );
            else return ResponseToAddUser.of("user unauthorized" );
        } catch (Exception e) {
            return ResponseToAddUser.of("EXCEPTION WHILE authUser !! = " + e);
        }
    }
}
