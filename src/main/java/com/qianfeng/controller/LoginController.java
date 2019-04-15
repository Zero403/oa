package com.qianfeng.controller;

import com.qianfeng.common.CommonInfo;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TUser;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public JsonBean login(String no, String pass, HttpSession session){

        try {
            TUser user = userService.login(no, pass);
            session.setAttribute(CommonInfo.LOGIN_USER, user);
            return JsonUtils.createJsonBean(1,1,null);
        } catch (IncorrectCredentialsException i){
            return JsonUtils.createJsonBean(0,1,"密码错误");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return JsonUtils.createJsonBean(0,1,"用户名错误");
        }catch (Exception e){
            return JsonUtils.createJsonBean(0,1, e.getMessage());
        }
    }

    @RequestMapping("/currentUser.do")
    public JsonBean currentUser(HttpSession session){
        return JsonUtils.createJsonBean(1, 1, session.getAttribute(CommonInfo.LOGIN_USER));
    }

    @RequestMapping("/userall.do")
    public JsonBean roleAll(int page, int limit){

        List<VUser> list = userService.findUserRole(page - 1, limit);
        return JsonUtils.createJsonBean(0,list.size(), list);
    }

    @RequestMapping("/userdel.do")
    public JsonBean delUser(int id){
        userService.delUser(id);
        return JsonUtils.createJsonBean(1000,1,null);
    }
}
