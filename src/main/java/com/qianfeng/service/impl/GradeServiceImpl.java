package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.TGradeMapper;
import com.qianfeng.entity.TCourse;
import com.qianfeng.entity.TGrade;
import com.qianfeng.service.GradeService;
import com.qianfeng.utils.PageListUtil;
import com.qianfeng.vo.VGrade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements GradeService {
    @Resource
    private TGradeMapper gradeDao;


    @Override
    public Map<String, Object> gradeList(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<VGrade> list = gradeDao.greadeList();
        Map<String, Object> map = PageListUtil.mapList(list);

        return map;
    }

    @Override
    public void updateGrade(TGrade grade) {
        gradeDao.updateByPrimaryKeySelective(grade);
    }

    @Override
    public void deleteGrade(int id) {

        int i = gradeDao.countStudentByGid(id);

        if (i > 0){
            throw new RuntimeException("改班级下仍有学生,删除失败");
        }
        gradeDao.deleteByPrimaryKey(id);
    }

    @Override
    public void addGrade(TGrade grade) {
        gradeDao.insertSelective(grade);
    }

    @Override
    public List<TCourse> allCourse() {
        return gradeDao.allCourse();
    }
}
