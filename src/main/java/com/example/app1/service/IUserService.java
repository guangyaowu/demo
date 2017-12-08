package com.example.app1.service;

import com.example.app1.model.User;

import java.util.List;

public interface IUserService {
    /**
     * 获取所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    long insert(User user);

    /**
     * 获取用户
     *
     * @param id
     * @return
     */
    User getById(long id);

    /**
     * 更新用户
     *
     * @param user
     */
    void update(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    void delete(long id);
}
