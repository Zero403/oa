package com.qianfeng.service;


import com.qianfeng.entity.TCourse;
import com.qianfeng.entity.TGrade;

import java.util.List;
import java.util.Map;

public interface GradeService {

    public Map<String, Object> gradeList(int page, int limit);

    public void updateGrade(TGrade grade);

    public void deleteGrade(int id);

    public void addGrade(TGrade grade);

    public List<TCourse> allCourse();
}
