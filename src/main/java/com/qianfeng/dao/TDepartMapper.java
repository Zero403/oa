package com.qianfeng.dao;

import com.qianfeng.entity.TDepart;

public interface TDepartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TDepart record);

    int insertSelective(TDepart record);

    TDepart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TDepart record);

    int updateByPrimaryKey(TDepart record);
}