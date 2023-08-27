package com.saurav.splitwise.dto;

import lombok.Data;

@Data
public class Response {
    private String message;
    private ResponseStatus responseStatus;

    public static Response getSucessResponse(String message){
        Response response = new Response();
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setMessage(message);
        return response;
    }

    public static Response getFailureResponse(String message){
        Response response = new Response();
        response.setResponseStatus(ResponseStatus.FAILURE);
        response.setMessage(message);
        return response;
    }

}
