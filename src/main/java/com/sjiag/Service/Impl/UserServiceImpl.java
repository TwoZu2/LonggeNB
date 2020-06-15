package com.sjiag.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjiag.Dao.Util;
import com.sjiag.PageUtils.PageResult;
import com.sjiag.PageUtils.Result;
import com.sjiag.Service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
   @Resource
   Util util;

    public void UserLogin(String username,String password,boolean rememberMe){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        System.out.println(rememberMe);
        token.setRememberMe(rememberMe);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
    }

}
