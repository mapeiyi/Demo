package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUser(int id){
        return userMapper.selectUser(id);
    }
}
