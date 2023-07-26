package com.abc.project1.controller;

import com.abc.project1.entity.User;
import com.abc.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService us;

    @PostMapping
    public String addNewUser(@RequestBody User user){
        User savedUser = us.addThisUser(user);
        return savedUser.toString();
    }
}
