package com.dialogfinance.cashback.dto;

import lombok.Data;

import javax.persistence.Id;

@Data
public class UserDto {

    @Id
    private String userName;

    private String name;


}
