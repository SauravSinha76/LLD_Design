package com.saurav.splitwise.dto;

import lombok.Data;

@Data
public class RegisterUserRequest {

    private String userName;
    private String phoneNumber;
    private String password;
}
