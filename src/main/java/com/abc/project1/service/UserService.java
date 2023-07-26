package com.abc.project1.service;

import com.abc.project1.entity.User;
import com.abc.project1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo ur;
    public User addThisUser(User user) {
        return ur.save(user);
    }

    public User getThisByUserId(int uploadedById) {
        return ur.findByUid(uploadedById);
    }
}
