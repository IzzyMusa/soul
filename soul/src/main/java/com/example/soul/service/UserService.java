package com.example.soul.service;

import com.example.soul.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static List<User> users = new ArrayList<>();

    private static Integer userCount = 3;

    static {
        users.add(new User(1, "Izzy", "Musa", 25, "izzy6174@gmail.com"));
        users.add(new User(2, "Aaron", "Burk", 25, "burk001@gmail.com"));
        users.add(new User(3, "Udaya", "Vag", 25, "udaya001@gmail.com"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(Integer id){
        for(User user : users){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }
}


