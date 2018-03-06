package com.denk.demo.annotation.controller;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.config.annotation.Reference;
import com.denk.demo.base.iface.IUser;
import com.denk.demo.base.model.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author: denk
 * desc:
 * date: 2018/3/6
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private IUser userSerivce;

    @RequestMapping("/{id}")
    public String getUserById(@PathVariable("id") String id) {
        User user = userSerivce.getUserById(id);
        try {
            if (user == null) return "NOT FOUND";
            return JSON.json(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
}
