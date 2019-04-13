package com.qianfeng.dao;

import com.qianfeng.entity.TUser;

import java.util.List;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    List<String> findRoleByName(String name);

    List<String> findPermisionByName(String name);


    String findPwdByName(String name);
}