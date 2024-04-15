package com.fas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fas.entity.User;
import com.fas.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> fetchAllUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping(path = "/validateUser")
    public ResponseEntity<User> validateUser(@RequestHeader(value = "userPhone") Long userPhone,
            @RequestHeader(value = "userPassword") String userPassword) {
        return userService.validateUser(userPhone, userPassword);
    }

    @GetMapping(path = "/id")
    public ResponseEntity<User> fetchByType(@RequestParam(name = "id") String userType) {
        return userService.fetchUserById(Integer.parseInt(userType));
    }

    @PutMapping(path = "/info")
    public ResponseEntity<String> updateUserInfo(@RequestParam(name = "id", required = true) int id,
            @RequestParam(name = "phno", required = false) Long phno,
            @RequestParam(name = "address", required = false) String userAddress) {
        return userService.updateUserInfo(id, phno, userAddress);
    }
}