package com.qianfeng.controller;

import com.qianfeng.common.CommonInfo;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TUser;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public JsonBean login(String no, String pass, HttpSession session){
        try {
            TUser user = userService.login(no, pass);
            session.setAttribute(CommonInfo.LOGIN_USER, user);
            return JsonUtils.createJsonBean(1,1,null);
        }catch (Exception e){

            return JsonUtils.createJsonBean(0, 1, e.getMessage());
        }
    }
}
