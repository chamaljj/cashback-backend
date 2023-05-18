package com.dialogfinance.cashback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Role {

    @Id
    private String roleName;
    private String roleDescription;

}
