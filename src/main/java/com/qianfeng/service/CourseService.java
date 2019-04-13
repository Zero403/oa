package com.qianfeng.service;

import com.qianfeng.entity.TCourse;

import java.util.List;

public interface CourseService {

    public void addCourse(TCourse tCourse);

    public List<TCourse> findAll();

    public void deleteCouById(Integer id);

    public TCourse findCourse(Integer id);

    public void updateCou(TCourse tCourse);
}
