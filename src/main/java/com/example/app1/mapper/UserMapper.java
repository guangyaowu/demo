package com.example.app1.mapper;

import com.example.app1.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();

    void insertSelective(User user);

    User getById(long id);

    void deleteById(long id);

    void updateSelective(User user);
}
