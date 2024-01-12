package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

public class User {

    @Getter
    @Setter
    private final String id;

    @Getter
    @Setter
    private final String password;

    @Getter
    @Setter
    private String name;


    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User create(String id, String password, String name){
        return new User(id, password, name);
    }

}
