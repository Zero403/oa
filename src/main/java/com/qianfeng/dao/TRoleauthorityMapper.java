package com.qianfeng.dao;

import com.qianfeng.entity.TRoleauthorityKey;

public interface TRoleauthorityMapper {
    int deleteByPrimaryKey(TRoleauthorityKey key);

    int insert(TRoleauthorityKey record);

    int insertSelective(TRoleauthorityKey record);
}