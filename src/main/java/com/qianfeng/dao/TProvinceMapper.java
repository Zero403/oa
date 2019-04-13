package com.qianfeng.dao;

import com.qianfeng.entity.TProvince;

public interface TProvinceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TProvince record);

    int insertSelective(TProvince record);

    TProvince selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TProvince record);

    int updateByPrimaryKey(TProvince record);
}