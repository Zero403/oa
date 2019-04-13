package com.qianfeng.dao;

import com.qianfeng.entity.TCheck;

public interface TCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCheck record);

    int insertSelective(TCheck record);

    TCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCheck record);

    int updateByPrimaryKey(TCheck record);
}