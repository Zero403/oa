package com.qianfeng.service.impl;

import com.qianfeng.dao.TStudentMapper;
import com.qianfeng.entity.TGrade;
import com.qianfeng.entity.TSchedule;
import com.qianfeng.entity.TStaff;
import com.qianfeng.entity.TStudent;
import com.qianfeng.service.StudentService;
import com.qianfeng.vo.VStu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired(required = false)
    private TStudentMapper studentMapper;

    @Override
    public void addStu(TStudent student) {

        studentMapper.insertSelective(student);

    }

    @Override
    public void deleteStuById(String no) {
        if (no == null) {
            throw new RuntimeException("不存在，无法删除！！！");
        }
        studentMapper.deleteByPrimaryKey(no);


    }

    @Override
    public List<VStu> findStudent(int page, int limit) {
        List<VStu> list = null;
        try {
            list = studentMapper.findAll(page, limit);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询异常！！！");
        }
        return list;
    }

    @Override
    public void updateStu(TStudent student) {

    }

    @Override
    public void addBatch(List<VStu> list) {
        int count = 1;
        List<VStu> tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            tempList.add(list.get(i));
            if (count % 100 != 0) {
                count++;
            } else {
                studentMapper.addBatch(tempList);
                tempList.clear();
                count = 1;
            }

        }
        if (tempList.size() != 0) {
            studentMapper.addBatch(tempList);
        }


    }

    @Override
    public List<TStaff> findName() {

        List<TStaff> list = null;
        try {
            list = studentMapper.findAllSta();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("错误");
        }
        return list;
    }

    @Override
    public List<TGrade> findAll() {
        List<TGrade> list = null;
        try {
            list = studentMapper.find();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("错误");
        }
        return list;
    }
}
