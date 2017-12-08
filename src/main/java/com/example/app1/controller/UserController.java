package com.example.app1.controller;

import com.example.app1.model.User;
import com.example.app1.service.IUserService;
import com.example.common.ActionResult;
import com.example.common.CommonActionResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("user.controller")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public ActionResult getAll() {
        List<User> users = userService.findAll();
        logger.info("获取所有用户[" + users + "]");
        return CommonActionResults.success(users, "获取成功！");
    }


    /**
     * 创建
     *
     * @param user
     * @return
     */
    @PutMapping("/user")
    public ActionResult create(User user) {
        long id = userService.insert(user);
        logger.info("创建用户[" + id + "]");
        return CommonActionResults.success(id, "创建成功！");
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public ActionResult update(@PathVariable long id) {
        userService.delete(id);
        logger.info("删除用户[" + id + "]");
        return CommonActionResults.success(id, "删除成功！");
    }

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @PostMapping("/user")
    public ActionResult update(User user) {
        userService.update(user);
        logger.info("更新用户[" + user.getId() + "]");
        return CommonActionResults.success(user.getId(), "更新成功！");
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public ActionResult getById(@PathVariable long id) {
        User user = userService.getById(id);
        logger.info("根据ID获取用户[" + id + "]");
        return CommonActionResults.success(user, "获取成功！");
    }

}
