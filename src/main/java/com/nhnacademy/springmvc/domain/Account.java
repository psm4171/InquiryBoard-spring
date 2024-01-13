package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

    private String id;

    private String password;

    private String name;

    private Role role;


}
