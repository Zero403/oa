package com.qianfeng.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TGrade;
import com.qianfeng.entity.TSchedule;
import com.qianfeng.entity.TStaff;
import com.qianfeng.entity.TStudent;
import com.qianfeng.service.StudentService;
import com.qianfeng.utils.ImportExcel;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VStu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/studentpage.do")
    public JsonBean findAllStu(int page, int limit){
        List<VStu> list = studentService.findStudent(page - 1, limit);

        return JsonUtils.createJsonBean(0,list.size(),list);

    }
    @RequestMapping("/studentadd.do")
    public void addStu(TStudent student, HttpServletRequest request, HttpServletResponse response) throws  Exception{

        student.setFlag(1);

        studentService.addStu(student);

        response.sendRedirect(request.getContextPath() + "/studentlist.html");
    }

    @RequestMapping("/studentdelete.do")
    public JsonBean deleteStu(String no) {
        studentService.deleteStuById(no);
        return JsonUtils.createJsonBean(1000,1,null);
    }


    @RequestMapping("/staffall.do")
    public JsonBean findAll() {
        List<TStaff> list = studentService.findName();
        return JsonUtils.createJsonBean(0, list.size(), list);
    }

    @RequestMapping("/gradeall.do")
    public JsonBean find() {
        List<TGrade> list = studentService.findAll();
        return JsonUtils.createJsonBean(0, list.size(), list);
    }

    @RequestMapping("/studentbatch.do")
    public void importExcel(@RequestParam MultipartFile excelFile , HttpServletRequest request, HttpServletResponse response) {


        try {
            String fileName = excelFile.getOriginalFilename();
            // 获取上传文件的输入流
            InputStream inputStream = excelFile.getInputStream();
            // 调用工具类中方法，读取excel文件中数据
            List<Map<String, Object>> sourceList = ImportExcel.readExcel(fileName, inputStream);

            // 将对象先转为json格式字符串，然后再转为List<SysUser> 对象
            ObjectMapper objMapper = new ObjectMapper();
            String infos = objMapper.writeValueAsString(sourceList);

            // json字符串转对象
            List<VStu> list = objMapper.readValue(infos, new TypeReference<List<VStu>>() {
            });

            // 批量添加
            studentService.addBatch(list);

            //  return JsonUtils.createJsonBean(1000, 1,null);
            response.sendRedirect(request.getContextPath() + "/studentlist.html");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();


            //return JsonUtils.createJsonBean(0,1, e.getMessage());
        }

    }

}
