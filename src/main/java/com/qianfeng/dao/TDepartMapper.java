package com.qianfeng.dao;

import com.qianfeng.entity.TDepart;
import com.qianfeng.vo.VDpart;

import java.util.List;

public interface TDepartMapper {
    int deleteByPrimaryKey(Integer id);

    //插入数据，增加
    int insert(TDepart record);

    int insertSelective(TDepart record);

    TDepart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TDepart record);

    //修改数据
    int updateByPrimaryKey(TDepart record);

    //删除数据
    public void deleteTDpart(Integer id);

    //展示数据
    public List<TDepart> findAllTDpart();

}