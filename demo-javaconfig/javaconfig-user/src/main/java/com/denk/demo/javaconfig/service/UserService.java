package com.denk.demo.javaconfig.service;

import com.denk.demo.base.iface.IUser;
import com.denk.demo.base.model.User;
import org.springframework.stereotype.Service;

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
        put("1001", new User("1001", "Jone-javaconfig"));
        put("1002", new User("1002", "Mike-javaconfig"));
    }};

    @Override
    public User getUserById(String id) {
        return users.get(id);
    }
}
