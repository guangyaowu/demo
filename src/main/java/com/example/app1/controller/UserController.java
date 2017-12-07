package com.example.app1.controller;

import com.example.app1.model.User;
import com.example.app1.service.IUserService;
import com.example.common.ActionResult;
import com.example.common.CommonActionResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("user.controller")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @GetMapping("/user-all")
    public ActionResult index() {
        List<User> users = userService.findAll();
        logger.info("获取所有用户[" + users + "]");
        return CommonActionResults.success(users, "获取成功！");
    }


}
