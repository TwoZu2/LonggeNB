package com.sjiag.Dao;


import java.util.List;
import java.util.Map;

public interface fmanagerDao {
    /**
     *考勤
     */
    //查询全部记录
    public Map queryForteacherId(Integer userId);//查询用户对应教师id（tea_id）
    public List<Map> queryForTamperAll(Map<String,Object> map);//查询记录

    //

}
