package com.qianfeng.dao;

import com.qianfeng.entity.TRoleauthorityKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface TRoleauthorityMapper {
    int deleteByPrimaryKey(TRoleauthorityKey key);

    int insert(TRoleauthorityKey record);

    int insertSelective(TRoleauthorityKey record);

    @Delete("DELETE FROM t_roleauthority WHERE rid = #{id}")
    void deleteByRoleId(int id);

    void insertByRidAid(@Param("rid") int rid, @Param("aids") int[] aids);
}