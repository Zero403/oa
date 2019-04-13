package com.qianfeng.service.impl;

import com.qianfeng.dao.TUserMapper;
import com.qianfeng.entity.TUser;
import com.qianfeng.service.UserService;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public void login(String no, String password) {
        new UsernamePasswordToken(no, password);
    }
}
