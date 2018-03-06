package com.denk.demo.annotation.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.denk.demo.base.iface.IUser;
import com.denk.demo.base.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: denk
 * desc:
 * date: 2018/3/6
 */
@Service
public class UserService implements IUser {

    private Map<String, User> users = new HashMap<String, User>() {{
        put("1001", new User("1001", "Jone-annotation"));
        put("1002", new User("1002", "Mike-annotation"));
    }};

    @Override
    public User getUserById(String id) {
        return users.get(id);
    }
}
