package com.qianfeng.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TStaff;
import com.qianfeng.service.StaffService;
import com.qianfeng.utils.ImportExcel;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Controller
public class ImporExcelController {
    @Autowired
    private StaffService staffService = null;


    @RequestMapping("/staffbatch.do")
    @ResponseBody
    public JsonBean importExcel(@RequestParam MultipartFile excelFile){


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
            List<TStaff> list = objMapper.readValue(infos, new TypeReference<List<TStaff>>() {});

            // 批量添加
            staffService.addTstaffBatch(list);

            return JsonUtils.createJsonBean(1, 10, null);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            return JsonUtils.createJsonBean(0, 10, e.getMessage());
        }

    }
}

