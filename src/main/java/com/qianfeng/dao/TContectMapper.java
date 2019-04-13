package com.qianfeng.dao;

import com.qianfeng.entity.TContect;

public interface TContectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TContect record);

    int insertSelective(TContect record);

    TContect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TContect record);

    int updateByPrimaryKey(TContect record);
}