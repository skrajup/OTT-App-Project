package com.abc.project1.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static <T> ResponseEntity<Map<String, Object>> generateResponse(T data, HttpStatus status, String message, String uri){
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("status", status);
        responseMap.put("data", data);
        responseMap.put("message", message);
        responseMap.put("requestedURI", uri);

        return  new ResponseEntity<>(responseMap, status);
    }
}
