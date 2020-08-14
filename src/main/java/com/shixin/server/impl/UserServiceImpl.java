package com.shixin.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.shixin.entity.User;
import com.shixin.dao.UserMapper;
import com.shixin.server.UserService;

/**
 * @author 今何许
 * @date 2020-08-14 14:03
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User loginUser = userMapper.login(user);
        if (loginUser != null) {
            return loginUser;
        }
        throw new RuntimeException("认证失败");
    }
}
