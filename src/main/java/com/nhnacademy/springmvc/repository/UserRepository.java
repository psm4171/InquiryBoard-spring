package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Account;

public interface UserRepository {
    boolean exists(String id);
    void register(String id, String password, String name, String email, boolean admin);
    Account getUser(String id);
    boolean matches(String id, String password);


}
