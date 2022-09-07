package com.example.lg.service;

import com.example.lg.model.User;
import com.example.lg.responsitory.UserResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserResponsitory responsitory;
    public User findUser(String name, String pass){
        return responsitory.findUserByNameAndPasswordLike(name, pass);
    }
}