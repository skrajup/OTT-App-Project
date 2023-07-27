package com.abc.project1.controller;

import com.abc.project1.ApiResponse.ResponseHandler;
import com.abc.project1.entity.User;
import com.abc.project1.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService us;

    @PostMapping
    public ResponseEntity<Map<String, Object>> addNewUser(@RequestBody User user, HttpServletRequest request){
        User savedUser = us.addThisUser(user);
        return ResponseHandler.generateResponse(savedUser, HttpStatus.CREATED, "new user creation success.", request.getRequestURI());
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllUsers(HttpServletRequest request){
        List<User> users = us.getAllUsers();
        return  ResponseHandler.generateResponse(users, HttpStatus.OK, "all users fetched success.", request.getRequestURI());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> deleteUserById(@PathVariable("userId") int userId, HttpServletRequest request){
        us.deleteThisUserById(userId);
        return ResponseHandler.generateResponse(null, HttpStatus.NOT_FOUND, "user with userId "+userId+" deleted success.", request.getRequestURI());
    }
}
