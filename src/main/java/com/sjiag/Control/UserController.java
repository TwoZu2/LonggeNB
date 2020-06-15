package com.sjiag.Control;

import com.sjiag.Dao.UserDao;
import com.sjiag.Dao.Util;
import com.sjiag.Service.ITest;
import com.sjiag.Service.Impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    UserServiceImpl userService;
    @Resource
    UserDao userDao;
    @Resource
    ITest iTest;
    @RequestMapping("login")
    public String login(String username,String password,boolean rememberMe) throws Exception {





        try {
            userService.UserLogin(username,password,rememberMe);
            System.out.println("登录成功!");




//            a a = new a();
//            a.onMessage("消息",null);

            return "index";
        } catch (Exception e) {
            System.out.println("登录失败!");
            return "login";
        }
    }
    @RequestMapping("regist")
    @ResponseBody
    public Object regist(String username,String password){
//        //加盐加密
//        int num=  new Random().nextInt(90000)+10000; //10000-99999
//            //注册的时候要对密码进行加密存储
//        Md5Hash md5Hash = new Md5Hash(password,num+"");
//
//            userDao.savaUser(username,md5Hash.toHex(),num+"");
        System.out.println(1);
      return iTest.findPage(1,3).getContent();


    }
}
