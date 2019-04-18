package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.TUserMapper;
import com.qianfeng.dao.TUserroleMapper;
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
    @Autowired
    private TUserroleMapper tUserroleMapper;

    @Override
    public TUser login(String no, String password) {


        UsernamePasswordToken token = new UsernamePasswordToken(no, password);

        Subject subject = SecurityUtils.getSubject();

        subject.login(token);


        return tUserMapper.findUserByName(no);
    }

    @Override
    public List<VUser> findUserRole(String no, int flag, int page, int limit) {

        List<VUser> list = tUserMapper.findAllUserWithRole(no, flag, page, limit);
        return list;
    }

    @Override
    public void delUser(int id) {
        tUserMapper.deleteByPrimaryKey(id);
        tUserMapper.delUserFromUserRole(id);
    }

    @Override
    public void updateUserRole(int uid, int[] rids) {
        tUserroleMapper.deleteByUserId(uid);
        if (null != rids){
            tUserroleMapper.insertUserRole(uid, rids);
        }

    }

    @Override
    public int findUserCount() {
        return tUserMapper.findUserCount();
    }


}
