package com.saurav.splitwise.commands;

import com.saurav.splitwise.controller.UserController;
import com.saurav.splitwise.dto.RegisterUserRequest;
import com.saurav.splitwise.dto.RegisterUserResponse;
import com.saurav.splitwise.exception.InvalidCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

@Component
public class RegisterUserCommand implements Command{
    final static String REGISTER_USER_COMMAND ="Register";

    private UserController userController;
    @Autowired
    public RegisterUserCommand(UserController controller){
        CommandRegistry.getInstance().register(REGISTER_USER_COMMAND,this);
        System.out.println("Inside RegisterUserCommand");
        this.userController = controller;
    }
    @Override
    public void validate(String input) throws InvalidCommandException {
        if(!StringUtils.hasLength(input)){
            throw new InvalidCommandException("The input is null or empty");
        }

        String[] split = input.split("\\s+");
        if(!split[0].equalsIgnoreCase("Register")){
            throw new InvalidCommandException("Not as per syntax");
        }
        if(split.length != 4){
            throw new InvalidCommandException("Length mismatch");
        }
    }

    @Override
    public void execute(String input) {
        String[] split = input.split("\\s+");
        String username = split[1];
        String phoneNumber = split[2];
        String password = split[3];

        RegisterUserRequest request = new RegisterUserRequest();
        request.setUserName(username);
        request.setPhoneNumber(phoneNumber);
        request.setPassword(password);

        RegisterUserResponse response = userController.registerUser(request);
        System.out.println(response);
    }
}
