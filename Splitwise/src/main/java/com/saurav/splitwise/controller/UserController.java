package com.saurav.splitwise.controller;

import com.saurav.splitwise.dto.RegisterUserRequest;
import com.saurav.splitwise.dto.RegisterUserResponse;
import com.saurav.splitwise.model.User;
import com.saurav.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest){
        try {
            User use = userService.registerUser(registerUserRequest.getUserName(), registerUserRequest.getPhoneNumber(), registerUserRequest.getPassword());
            return RegisterUserResponse.getSuccessResponse(use);
        }catch (Exception e){
            return RegisterUserResponse.getFailureResponse(e.getMessage());
        }

    }
}
