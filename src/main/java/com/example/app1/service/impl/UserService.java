package com.example.app1.service.impl;

import com.example.app1.mapper.UserMapper;
import com.example.app1.model.User;
import com.example.app1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("user.service")
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public long insert(User user) {
        userMapper.insertSelective(user);
        return user.getId();
    }

    @Cacheable(value = "user-cache", key = "'user-'+#id")
    @Override
    public User getById(long id) {
        return userMapper.getById(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateSelective(user);
    }

    @CacheEvict(value = "user-cache", key = "'user-'+#id")
    @Override
    public void delete(long id) {
        userMapper.deleteById(id);
    }
}
