package com.qianfeng.dao;

import com.qianfeng.entity.TCounty;

public interface TCountyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCounty record);

    int insertSelective(TCounty record);

    TCounty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCounty record);

    int updateByPrimaryKey(TCounty record);
}