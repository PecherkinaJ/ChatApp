package com.MyChat.controller;

import com.MyChat.repositories.UserRepository;
import com.MyChat.response.StatusInResponse;
import com.MyChat.user.AuthUser;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthUserController {

    private final UserRepository userRepository;

    public AuthUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/auth")
    public StatusInResponse authUser(@RequestBody AuthUser user) {
        try {
            boolean result = userRepository.authUser(user);
            if (result) {
                // TODO: юзер добавляется в БД, где записаны участники, осуществившие вход
                userRepository.addNewOnlineUser(user.getEmail());
                return StatusInResponse.of("user authorized");
            }
            else return StatusInResponse.of("user unauthorized");
        } catch (Exception e) {
            return StatusInResponse.of("EXCEPTION WHILE authUser !! = " + e);
        }
    }

    // TODO: создать эндпоинт для выхода из системы - пользователь удаляется из БД онлайн-участников
//    @PostMapping("/logout")
//    public StatusInResponse logoutUser(@RequestBody AuthUser user) {
//        try {
//            boolean result = userRepository.authUser(user);
//            if (result) {
//
//                return StatusInResponse.of("user logout" );
//            }
//            else return StatusInResponse.of("user unauthorized" );
//
//            // TODO: юзер добавляется в БД, где записаны участники, осуществившие вход
//            // TODO: создать эндпоинт для выхода из системы - пользователь удаляется из БД онлайн-участников
//        } catch (Exception e) {
//            return StatusInResponse.of("EXCEPTION WHILE authUser !! = " + e);
//        }
//    }
}
