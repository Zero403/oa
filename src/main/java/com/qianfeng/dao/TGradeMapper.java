package com.qianfeng.dao;

import com.qianfeng.entity.TGrade;

public interface TGradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TGrade record);

    int insertSelective(TGrade record);

    TGrade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TGrade record);

    int updateByPrimaryKey(TGrade record);
}