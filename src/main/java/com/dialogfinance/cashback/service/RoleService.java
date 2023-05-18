package com.dialogfinance.cashback.service;

import com.dialogfinance.cashback.entity.Role;
import com.dialogfinance.cashback.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
