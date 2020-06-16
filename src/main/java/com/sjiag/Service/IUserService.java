package com.sjiag.Service;

import com.github.pagehelper.PageInfo;
import com.sjiag.PageUtils.PageResult;

import java.util.List;
import java.util.Map;

public interface IUserService {


    public void UserLogin(String username,String password,boolean rememberMe);
    public List finduser(Map map);
}
