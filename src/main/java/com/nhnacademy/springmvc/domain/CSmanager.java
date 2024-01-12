package com.nhnacademy.springmvc.domain;

public class CSmanager extends User implements Admin{

    public CSmanager(String id, String password, String name, String email) {
        super(id, password, name, email);
    }
}
