package com.qianfeng.service.impl;

import com.qianfeng.dao.TUserMapper;
import com.qianfeng.entity.TUser;
import com.qianfeng.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser login(String no, String password) {

        UsernamePasswordToken token = new UsernamePasswordToken(no, password);

        Subject subject = SecurityUtils.getSubject();

        subject.login(token);

        return tUserMapper.findPwdByName(no);
    }
}
