package com.qianfeng.dao;

import com.qianfeng.entity.TInterviewquest;

public interface TInterviewquestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TInterviewquest record);

    int insertSelective(TInterviewquest record);

    TInterviewquest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TInterviewquest record);

    int updateByPrimaryKeyWithBLOBs(TInterviewquest record);

    int updateByPrimaryKey(TInterviewquest record);
}