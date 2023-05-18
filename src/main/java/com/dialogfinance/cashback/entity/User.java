package com.dialogfinance.cashback.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name ="users")
@Entity
public class User {

    @Id
    private String userName;

    private String name;

    private String password;

    private String roleName;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;



    }

