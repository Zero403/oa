package com.qianfeng.service;

import com.qianfeng.entity.TGrade;
import com.qianfeng.entity.TSchedule;
import com.qianfeng.entity.TStaff;
import com.qianfeng.entity.TStudent;
import com.qianfeng.vo.VStu;

import java.util.List;

public interface StudentService {

    public void addStu(TStudent student);

    public void deleteStuById(String no);

    public List<VStu> findStudent(int page, int limit);

    public void updateStu(TStudent student);
    public void addBatch(List<VStu> list);
    public List<TStaff> findName();
    public List<TGrade> findAll();

}
