package com.qianfeng.dao;

import com.qianfeng.entity.TStudent;

public interface TStudentMapper {
    int deleteByPrimaryKey(String no);

    int insert(TStudent record);

    int insertSelective(TStudent record);

    TStudent selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(TStudent record);

    int updateByPrimaryKey(TStudent record);
}