package com.qianfeng.dao;

import com.qianfeng.entity.TDepart;
import com.qianfeng.entity.TStaff;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TStaffMapper {
    int deleteByPrimaryKey(String no);


    //增加数据
    int insert(TStaff record);

    int insertSelective(TStaff record);

    TStaff selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(TStaff record);

    int updateByPrimaryKey(TStaff record);
    //展示所有
    public List<TStaff> findAll();
    //删除
    public void delStaff(String no);
    //编辑
    public void updateStaff(TStaff staff);

    @Select("SELECT * from t_depart ")
    public  List<TDepart> findAlldep();

    //批量添加
    public void addBatch(List<TStaff> list);


}