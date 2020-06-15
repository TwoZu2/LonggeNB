package com.sjiag.Dao;

import com.sjiag.Beans.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserDao {
    public User queryUserByUsername(String username);
    public void savaUser(String username,String password,String PwdSalt);
}
