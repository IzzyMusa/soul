package com.example.soul.controller;

import com.example.soul.exception.UserNotFoundException;
import com.example.soul.model.User;
import com.example.soul.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User>  getUser(@PathVariable Integer id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser =  userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users")
    public void deleteUser() {
        userRepository.deleteAll();
    }

        @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        userRepository.deleteById(id);

        }
}
