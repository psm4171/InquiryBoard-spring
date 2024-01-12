package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.repository.UserRepository;

public class LoginController {
    private final UserRepository userRepository;


    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
