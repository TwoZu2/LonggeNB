package com.sjiag.Service.Impl;

import com.sjiag.Dao.Tercher;
import com.sjiag.Dao.Util;
import com.sjiag.Service.ITeacher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TercherImpl implements ITeacher {
    @Resource
    Tercher tercher;
    @Resource
    Util util;
    @Override
    public List findone() {
        return tercher.findone();
    }

    @Override
    public boolean updateImg(String newimg) {
        Map map = new HashMap();
        map.put("tea_img",newimg);
        Map map1 = new HashMap();
        map1.put("tea_id",3);
        return  util.update("tb_teacher",map,map1);

    }

    @Override
    public List findtap(Map map) {
        return util.findlike("tb_teataper",map);
    }

    @Override
    public boolean tap(Integer id,String time,String tapname) {
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        map2.put("tea_id",id);
        if(time!=null){
                map2.put(tapname,1);
                map2.put("tap_time",time);
            return util.sava("tb_teataper",map2);
        }
            map1.put(tapname,1);
        return util.update("tb_teataper",map1,map2);
    }
}
