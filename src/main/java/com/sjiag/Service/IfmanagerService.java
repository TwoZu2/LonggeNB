package com.sjiag.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 辅导员模块
 *
 * 功能：
 *      1.考勤模块： 查看打卡记录，增加 修改 个逻辑
 *      2.班级管理：
 *                  查看所带班级：查询tb_teacher获取tea_id,查询tb_teacla获取cla_id,根据cla_id,返回cla_id,ten_id,其余数据
 *                  发布班级通知：插入消息通知tb_avis
 *                  查询发布的消息:查询消息通知（返回:av_id,av_message,av_time,tea_id(name),tea_id(name)）
 *      3.学生管理:
 *              查询记录:(返回：tb_school.sc_name,tb_class.cla_name,其他数据)
 *              修改(根据stu_id):查询分院名对应id(sc_id),查询班级名对应id(cla_id)
 *         学生考勤查看: 通过tb_teacla查询所有匹配的cla_id，查询全部：（返回  cla_name,cla_id,其他数据）
 */
public interface IfmanagerService {
    /**
     * 考勤
     */
    public List<Map> kaoqinFmanagerService(Integer userId);//查询考勤
    public int dakaFmanagerService(String table, Map<String,Object> map,Map map1);//早上，下午签到
    public int xiabanFmanagerService(String table,Map<String,Object> map,Map map1);//早上，下午下班

}
