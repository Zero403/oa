package com.qianfeng.dao;

import com.qianfeng.entity.TLoginlog;

public interface TLoginlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TLoginlog record);

    int insertSelective(TLoginlog record);

    TLoginlog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TLoginlog record);

    int updateByPrimaryKey(TLoginlog record);
}