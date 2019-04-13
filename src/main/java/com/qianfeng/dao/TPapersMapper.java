package com.qianfeng.dao;

import com.qianfeng.entity.TPapers;

public interface TPapersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TPapers record);

    int insertSelective(TPapers record);

    TPapers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TPapers record);

    int updateByPrimaryKey(TPapers record);
}