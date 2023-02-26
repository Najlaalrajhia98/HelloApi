package com.dynamicdoers.myapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/v1/api")
public class ControllerClass {
    @GetMapping
    public HashMap<String, Object> getHomePageContent(@RequestParam(value = "myname", defaultValue = "Mr/Ms") String name) {
        try {
            HashMap<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.OK.value());
            response.put("message", "Hello " + name + "!");
            return response;
        } catch (Exception e) {
            // If an error occurs, return a 500 (Internal Server Error) status code and an error message
            HashMap<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            errorResponse.put("message", "An error occurred: " + e.getMessage());
            return errorResponse;
        }
    }
}
