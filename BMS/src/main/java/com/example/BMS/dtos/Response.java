package com.example.BMS.dtos;

import lombok.Data;

@Data
public class Response {

    private String message;
    private ResponseStatus responseStatus;

    public static Response getSuccessResponse(String message){
        Response response = new Response();
        response.responseStatus = ResponseStatus.SUCCESS;
        response.message = message;
        return response;
    }

    public static Response getFailureResponse(String message){
        Response response = new Response();
        response.responseStatus = ResponseStatus.FAILURE;
        response.message = message;
        return response;
    }

}
