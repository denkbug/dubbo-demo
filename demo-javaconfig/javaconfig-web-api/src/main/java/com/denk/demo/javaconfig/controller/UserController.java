package com.denk.demo.javaconfig.controller;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.denk.demo.base.iface.IUser;
import com.denk.demo.base.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ReferenceConfig<IUser> referenceConfig;
    @Autowired
    private ReferenceConfigCache referenceConfigCache;
    @Autowired
    private IUser userSerivce;

    @RequestMapping("/{id}")
    public String getUserById(@PathVariable("id") String id) {
        //User user = referenceConfig.get().getUserById(id);
        //User user = referenceConfigCache.get(referenceConfig).getUserById(id);
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
