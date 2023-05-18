package com.dialogfinance.cashback.controller;

import com.dialogfinance.cashback.configuration.JwtRequestFilter;
import com.dialogfinance.cashback.entity.Customer;
import com.dialogfinance.cashback.entity.User;
import com.dialogfinance.cashback.service.UserService;
import com.dialogfinance.cashback.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api")
@RestController
@Slf4j
public class UserController{

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    String username = null;
    String jwtToken = null;

    @PostMapping("/users")
    @PreAuthorize("hasRole('Super Admin')")
    public User registerNewUser(@RequestBody User user) {

        log.info("Create a new user Successfully ...");
        log.info("Create a new user Successfully ..."+user);
        return userService.registerNewUser(user);

    }
    @PostMapping("/admins")
    @PreAuthorize("hasRole('Super Admin')")
    public User registerNewAdmin(@RequestBody User user) {

        log.info("Create a new admin Successfully ...");
        log.info("Create a new admin Successfully ..."+user);

        return userService.registerNewAdmin(user);

    }


    @GetMapping("/user/{userName}")
    public ResponseEntity<?> findUserByUserName(@PathVariable("userName") String userName) {
        log.info(userName);
        User userEntity = userService.findUserByUserName(userName);
        return ResponseEntity.ok(userEntity);

    }
    @GetMapping("/users")
    @PreAuthorize("hasRole('admin') or hasRole('Super Admin')")
    public List<User> findAllUser(){

        return userService.findAllUser();
    }


}
                   