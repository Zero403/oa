package com.qianfeng.service;

import com.qianfeng.entity.TUser;
import com.qianfeng.vo.VUser;

import java.util.List;


public interface UserService {
    public TUser login(String no, String password);


    public List<VUser> findUserRole(String no, int flag, int page, int limit);

    public void delUser(int id);

    public void updateUserRole(int uid, int[] rid);

    int findUserCount();

}
