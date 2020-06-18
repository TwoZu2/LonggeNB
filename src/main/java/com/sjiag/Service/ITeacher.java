package com.sjiag.Service;

import java.util.List;
import java.util.Map;

public interface ITeacher {
    List findone();
    boolean updateImg(String newimg);
    List findtap(Map map);
    boolean tap(Integer id,String time,String tapname);
}
