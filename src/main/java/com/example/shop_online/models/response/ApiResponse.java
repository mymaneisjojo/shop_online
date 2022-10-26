package com.example.shop_online.models.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiResponse {
    private  String message;
    private  Boolean success;
    private  String timestamp;
    private  String cause;
    private  String path;

    public ApiResponse(Boolean success, String message, String cause, String timestamp, String path) {

        this.success = success;
        this.message = message;
        this.cause = cause;
        this.timestamp = timestamp;
        this.path = path;
    }
}
