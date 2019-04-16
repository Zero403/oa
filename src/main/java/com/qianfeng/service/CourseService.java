package com.qianfeng.service;

import com.qianfeng.entity.TCourse;

import java.util.List;

public interface CourseService {

    public void addCourse(TCourse tCourse);

    public List<TCourse> findAllCourse();

    public void deleteCouById(Integer id);

    public TCourse findCourseByid(Integer id);

    public void updateCou(TCourse tCourse);
}
