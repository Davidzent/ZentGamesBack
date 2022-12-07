package com.example.zent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.zent.module.User;
import com.example.zent.repository.UserRepo;

@Service
@Transactional
public class UserService {
    private UserRepo ur;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepo ur) {
        this.ur = ur;
    }

    public User register(User u) {
        return ur.save(u);
    }

    public User login(User u) {
        return ur.findOneByUsernameAndPassword(u.getUsername(), u.getPassword());
    }

    public List<User> getAllUsers() {
        return ur.findAll();
    }

    public User update(User u) {
        return ur.save(u);
    }

    public User getProfileByEmail(User u){
        return ur.findOneByEmail(u.getEmail());
    }
}
