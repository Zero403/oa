package com.qianfeng.dao;

import com.qianfeng.entity.TSchedule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TScheduleMapper {
    int deleteByPrimaryKey(String no);

    int insert(TSchedule record);

    int insertSelective(TSchedule record);

    TSchedule selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(TSchedule record);

    int updateByPrimaryKey(TSchedule record);


}