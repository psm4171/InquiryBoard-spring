package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.User;

public interface UserRepository {
    boolean exists(String id);
    void register(String id, String password, String name, String email, boolean admin);
    User getUser(String id);
    boolean matches(String id, String password);


}
