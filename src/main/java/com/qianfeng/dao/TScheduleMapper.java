package com.qianfeng.dao;

import com.qianfeng.entity.TSchedule;

public interface TScheduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TSchedule record);

    int insertSelective(TSchedule record);

    TSchedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSchedule record);

    int updateByPrimaryKey(TSchedule record);
}