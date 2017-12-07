package com.example.app1.service.impl;

import com.example.app1.mapper.UserMapper;
import com.example.app1.model.User;
import com.example.app1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("user.service")
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "user-cache")
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
