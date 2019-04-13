package com.qianfeng.dao;

import com.qianfeng.entity.TUserroleKey;

public interface TUserroleMapper {
    int deleteByPrimaryKey(TUserroleKey key);

    int insert(TUserroleKey record);

    int insertSelective(TUserroleKey record);
}