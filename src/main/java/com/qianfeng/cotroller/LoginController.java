package com.qianfeng.cotroller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public JsonBean login(String no, String pass){
        userService.login(no, pass);
        return JsonUtils.createJsonBean(1,1,null);
    }
}
