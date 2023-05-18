package com.dialogfinance.cashback.controller;

import com.dialogfinance.cashback.entity.Role;
import com.dialogfinance.cashback.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping({"/roles"})
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
}
