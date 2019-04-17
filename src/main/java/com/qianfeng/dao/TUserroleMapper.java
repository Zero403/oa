package com.qianfeng.dao;

import com.qianfeng.entity.TUserroleKey;
import org.apache.ibatis.annotations.Param;

public interface TUserroleMapper {
    int deleteByPrimaryKey(TUserroleKey key);

    int insert(TUserroleKey record);

    int insertSelective(TUserroleKey record);

    void deleteByUserId(int id);

    void insertUserRole(@Param("uid") int uid, @Param("rids") int[] rids);
}