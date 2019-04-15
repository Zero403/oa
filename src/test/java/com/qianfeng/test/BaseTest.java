package com.qianfeng.test;

import com.qianfeng.dao.TAuthorityMapper;
import com.qianfeng.dao.TUserMapper;
import com.qianfeng.vo.VMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-bean.xml")
public class BaseTest {

    @Resource
    private TAuthorityMapper dao;


    @Test
    public void test1(){
        VMenu list = dao.findMenuByUserId(2);
        System.out.println(list);
    }
}
