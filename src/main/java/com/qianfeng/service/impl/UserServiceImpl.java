package com.qianfeng.service.impl;

import com.qianfeng.dao.TUserMapper;
import com.qianfeng.entity.TUser;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.VUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser login(String no, String password) {

        UsernamePasswordToken token = new UsernamePasswordToken(no, password);

        Subject subject = SecurityUtils.getSubject();

        subject.login(token);


        return tUserMapper.findUserByName(no);
    }

    @Override
    public List<VUser> findUserRole(int page, int limit) {


        return tUserMapper.findAllUserWithRole(page, limit);
    }

    @Override
    public void delUser(int id) {
        tUserMapper.deleteByPrimaryKey(id);
    }
}
