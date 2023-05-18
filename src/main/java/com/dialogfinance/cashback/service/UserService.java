package com.dialogfinance.cashback.service;

import com.dialogfinance.cashback.dto.UserDto;
import com.dialogfinance.cashback.entity.*;
import com.dialogfinance.cashback.exception.ResourceNotFoundException;
import com.dialogfinance.cashback.repository.RoleRepository;
import com.dialogfinance.cashback.repository.UserRepository;
import com.dialogfinance.cashback.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtService jwtService;


    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("user role");
        roleRepository.save(userRole);


    }
    public void updateUser() {
        User user = new User();
        user.setUserName(user.getUserName());
        user.setPassword(getEncodedPassword(user.getPassword()));
        user.setName(user.getName());
        user.setName(user.getRoleName());
        Set<Role> userRoles = new HashSet<>();
        user.setRole(userRoles);
        userRepository.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleRepository.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setPassword(getEncodedPassword(user.getPassword()));
        return userRepository.save(user);
    }

    public User registerNewAdmin(User user) {
        Role role = roleRepository.findById("Admin").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setPassword(getEncodedPassword(user.getPassword()));
        return userRepository.save(user);
    }

    public String getEncodedPassword(String password) {

        return passwordEncoder.encode(password);

    }

    public User findUserByUserName(String userName){

        return userRepository.findByUserName(userName);
    }

    public List<User> findAllUser() {

        return userRepository.findAll();
    }


}
