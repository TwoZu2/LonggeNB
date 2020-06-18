package com.sjiag.Service.Impl;

import com.sjiag.Dao.Util;
import com.sjiag.Dao.fmanagerDao;
import com.sjiag.Service.IfmanagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class fmanagerServiceImpl implements IfmanagerService {
    @Resource
    fmanagerDao Dao;    //模块Dao
    @Resource
    Util util;      //工具Dao

    @Override
    public List<Map> kaoqinFmanagerService(Integer userId) {
        //获取用户名对应的教师id
        Map map=Dao.queryForteacherId(userId);
        Integer teaid = (Integer) map.get("teaId");
        System.out.println(teaid);
        return Dao.queryForTamperAll(map);
    }

    @Override
    public int dakaFmanagerService(String table, Map<String, Object> map, Map map1) {
        return 0;
    }

    @Override
    public int xiabanFmanagerService(String table, Map<String, Object> map, Map map1) {
        return 0;
    }
}
