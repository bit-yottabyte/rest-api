package com.example.rest_api.controller;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import com.example.rest_api.model.User;
import com.example.rest_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> userList = new ArrayList<>();
            userRepository.findAll().forEach(userList::add);

            if(userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userData = userRepository.findById(id);

        if(userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User userObj = userRepository.save(user);

        return new ResponseEntity<>(userObj, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User newUserData) {
        Optional<User> oldUserData = userRepository.findById(id);

        if(oldUserData.isPresent()) {
            User updatedUserData = oldUserData.get();
            updatedUserData.setUsername(newUserData.getUsername());
            updatedUserData.setFirstName(newUserData.getFirstName());
            updatedUserData.setLastName(newUserData.getLastName());
            updatedUserData.setEmail(newUserData.getEmail());
            updatedUserData.setPhoneNumber(newUserData.getPhoneNumber());

            User userObj = userRepository.save(updatedUserData);
            return new ResponseEntity<>(userObj, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id) {
        userRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
