package com.qianfeng.dao;

import com.qianfeng.entity.TLog;

public interface TLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TLog record);

    int insertSelective(TLog record);

    TLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TLog record);

    int updateByPrimaryKey(TLog record);
}