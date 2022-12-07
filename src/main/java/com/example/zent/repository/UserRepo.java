package com.example.zent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zent.module.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findOneByUsernameAndPassword(String username, String password);

    User findOneByEmail(String email);

}