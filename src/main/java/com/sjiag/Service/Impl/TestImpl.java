package com.sjiag.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjiag.Dao.Util;
import com.sjiag.PageUtils.PageResult;
import com.sjiag.PageUtils.Result;
import com.sjiag.Service.ITest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TestImpl implements ITest {

    @Resource
    Util util;

    /**
     * 调用分页插件完成分页
     *  此方法不主动调用,主要调用下面的 findPage 方法
     *  因为 findPage 方法工具类封装了layui的格式
     */
    public PageInfo<Object> getPageInfo(int page, int size) {
        PageHelper.startPage(page, size);
        List sysMenus = util.find("tb_users");

        return new PageInfo<Object>(sysMenus);
    }

    @Override
    public PageResult findPage(int num, int size) {
        return Result.getPageResult(getPageInfo(num,size));
    }
    /**
     * 剩下的 crud 自己测试
     *
     */
}
