package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.CSmanager;
import com.nhnacademy.springmvc.domain.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository{

    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public boolean exists(String id) {
        return userMap.containsKey(id);
    }

    @Override
    public void register(String id, String password, String name, String email, boolean admin) {

        User user;

        if(admin){
            user = new CSmanager(id, password, name, email);
        }else {
            user = new User(id, password, name, email);
        }

        userMap.put(id, user);
    }

    @Override
    public User getUser(String id) {
        return userMap.get(id);
    }

    @Override
    public boolean matches(String id, String password) {
        return Optional.ofNullable(getUser(id))
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

}
