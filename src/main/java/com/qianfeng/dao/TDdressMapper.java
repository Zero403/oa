package com.qianfeng.dao;

import com.qianfeng.entity.TDdress;

public interface TDdressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TDdress record);

    int insertSelective(TDdress record);

    TDdress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TDdress record);

    int updateByPrimaryKey(TDdress record);
}