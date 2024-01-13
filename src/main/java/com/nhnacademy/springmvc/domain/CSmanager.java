package com.nhnacademy.springmvc.domain;

public class CSmanager extends Account implements Admin{

    public CSmanager(String id, String password, String name, String email) {
        super(id, password, name, email);
    }
}
