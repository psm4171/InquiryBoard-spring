package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.CSmanager;
import com.nhnacademy.springmvc.domain.Account;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository{

    private final Map<String, Account> userMap = new HashMap<>();

    @Override
    public boolean exists(String id) {
        return userMap.containsKey(id);
    }

    @Override
    public void register(String id, String password, String name, String email, boolean admin) {

        Account user;

        if(admin){
            user = new CSmanager(id, password, name, email);
        }else {
            user = new Account(id, password, name, email);
        }

        userMap.put(id, user);
    }

    @Override
    public Account getUser(String id) {
        return userMap.get(id);
    }

    @Override
    public boolean matches(String id, String password) {
        return Optional.ofNullable(getUser(id))
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

}
