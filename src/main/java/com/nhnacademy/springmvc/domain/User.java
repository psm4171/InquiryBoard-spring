package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {


    private final String id;

    private final String password;

    private String name;

    private String email;


    public User(String id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;

    }

}
