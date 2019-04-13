package com.qianfeng.dao;

import com.qianfeng.entity.TCourse;

import java.util.List;

public interface TCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCourse record);

    int insertSelective(TCourse record);

    TCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCourse record);

    int updateByPrimaryKey(TCourse record);

    public  TCourse  findByName(String name);

    public   List<TCourse> findAll();

}