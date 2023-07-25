package com.abc.project1.repository;

import com.abc.project1.entity.Genre;
import com.abc.project1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUid(int userId);
}
