package com.qianfeng.dao;

import com.qianfeng.entity.TReport;

public interface TReportMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TReport record);

    int insertSelective(TReport record);

    TReport selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TReport record);

    int updateByPrimaryKeyWithBLOBs(TReport record);

    int updateByPrimaryKey(TReport record);
}