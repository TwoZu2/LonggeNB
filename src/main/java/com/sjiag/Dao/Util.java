package com.sjiag.Dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Util {
    /****
     *
     * @param table 表名
     * @return
     */
    //查全部 + 总条数
    public List<?> find(@Param("table") String table);

    /***
     *
     * @param table 表名
     * @param map  条件(key: 字段名   value: 值)
     * @return
     */
    //模糊查询 + 总条数
    public List<?> findlike(@Param("table") String table,@Param("map") Map<String,Object> map);

    /****
     *
     * @param table 表名
     * @param map  参数列表(key: 字段名   value: 添加的值)
     * @return
     */
    //添加
    public boolean sava(@Param("table") String table,@Param("map")Map<String,Object> map);

    /**
     *
     * @param table 表名
     * @param map 参数列表(key: 字段名   value: 判断的值) 一般情况只传入Id足矣
     * @return
     */
    //删除
    public boolean deleteById(@Param("table") String table,@Param("map")Map<String,Object> map);

    /**
     *
     * @param table 表名
     * @param map 参数列表(key: 字段名   value: 修改的值)
     * @param map1 条件列表(key: 字段名   value: 条件值) 一般情况只传入Id足矣
     * @return
     */
    //修改
    public boolean update(@Param("table") String table,@Param("map")Map<String,Object> map,@Param("id") Map map1);
}
