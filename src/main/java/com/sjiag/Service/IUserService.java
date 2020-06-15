package com.sjiag.Service;

import com.github.pagehelper.PageInfo;
import com.sjiag.PageUtils.PageResult;

public interface IUserService {


    public void UserLogin(String username,String password,boolean rememberMe);

}
