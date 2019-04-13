package com.qianfeng.dao;

import com.qianfeng.entity.TWork;

public interface TWorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TWork record);

    int insertSelective(TWork record);

    TWork selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TWork record);

    int updateByPrimaryKey(TWork record);
}