package com.qianfeng.controller;

import com.qianfeng.common.CommonInfo;
import com.qianfeng.common.JsonBean;
import com.qianfeng.common.JsonIp;
import com.qianfeng.entity.TLoginlog;
import com.qianfeng.entity.TUser;
import com.qianfeng.service.LoginLogService;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.IpUtils;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @Resource
    private LoginLogService loginLogService;

    @RequestMapping("/login.do")
    public JsonBean login(String no, String pass, HttpSession session, String ip){

        try {
            TUser user = userService.login(no, pass);
            session.setAttribute(CommonInfo.LOGIN_USER, user);
            TLoginlog tLoginlog = new TLoginlog();
            tLoginlog.setNo(user.getNo());
            tLoginlog.setCreatetime(new Date());
            IpUtils ipUtils = new IpUtils();
            tLoginlog.setIp(ip);
            JsonIp ip1 = ipUtils.getAddresses("ip=" + ip, "utf-");
            if (0 == ip1.getCode()){
                tLoginlog.setLocation(ip1.getData().getRegion() + ip1.getData().getCity());
            }
            loginLogService.addLoginLog(tLoginlog);
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
    public JsonBean roleAll(String no, Integer flag, Integer page, Integer limit){
        if (null == flag){
            flag = 1;
        }
        List<VUser> list = userService.findUserRole(no, flag, page -1, limit);
        int total = 10;
        total = userService.findUserCount();
        return JsonUtils.createJsonBean(0, total, list);
    }

    @RequestMapping("/userdel.do")
    public JsonBean delUser(int id){
        userService.delUser(id);
        return JsonUtils.createJsonBean(1000,1,null);
    }

    @RequestMapping("/userroleedit.do")
    public JsonBean editUserRole(int id, int[] rids){

        userService.updateUserRole(id, rids);
        return JsonUtils.createJsonBean(1000,1, null);
    }

}
