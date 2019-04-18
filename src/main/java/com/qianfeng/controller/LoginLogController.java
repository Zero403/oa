package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.service.LoginLogService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/loginlog")
public class LoginLogController {

    @Autowired
    private LoginLogService loginLogService;

    @RequestMapping("/loginloglist.do")
    public JsonBean loginLIst(Integer page, Integer limit){
        Map<String, Object> map = loginLogService.loginlogList(page, limit);

        return JsonUtils.createJsonBean(0,Integer.parseInt(map.get("total").toString()), map.get("rows"));
    }
}
