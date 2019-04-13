package com.qianfeng.dao;

import com.qianfeng.entity.TMsg;

public interface TMsgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TMsg record);

    int insertSelective(TMsg record);

    TMsg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TMsg record);

    int updateByPrimaryKeyWithBLOBs(TMsg record);

    int updateByPrimaryKey(TMsg record);
}