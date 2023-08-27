package com.saurav.splitwise.dto;

import com.saurav.splitwise.model.User;
import lombok.Data;

@Data
public class RegisterUserResponse {
    private User user;
    private Response response;

    public static RegisterUserResponse getSuccessResponse(User user){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setUser(user);
        registerUserResponse.setResponse(Response.getSucessResponse("User create successfully"));
        return registerUserResponse;
    }

    public static RegisterUserResponse getFailureResponse(String message){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setResponse(Response.getFailureResponse(message));
        return registerUserResponse;
    }
}
