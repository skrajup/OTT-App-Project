package com.abc.project1.controller;

import com.abc.project1.entity.User;
import com.abc.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    @Transactional
    public String getAllUsers(){
        return us.getAllUsers().toString();
    }

    @DeleteMapping("/{userId}")
    public String deleteUserById(@PathVariable("userId") int userId){
        us.deleteThisUserById(userId);
        return "user deleted";
    }
}
