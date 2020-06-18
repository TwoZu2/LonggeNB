package com.sjiag.Control;

import com.sjiag.Service.ITeacher;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("tea")
public class TercherController {
    @Resource
    ITeacher iTeacher;
    @RequestMapping("findone")
    public Object findone(ModelAndView modelAndView){
        List list = iTeacher.findone();
        System.out.println();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("page/Person");
        return modelAndView;
    }
    @PostMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file) throws IOException {
      Map map= UploadImg.upload(file);
      iTeacher.updateImg((String) map.get("data"));
      return map;
    }
    @RequestMapping("findtap")
    @ResponseBody
    public Object findtap(@RequestParam("time") String time,@RequestParam("id") Integer id){
        Map m = new HashMap();
        m.put("tap_time",time);
        m.put("tea_id",id);
        List list = iTeacher.findtap(m);
        System.out.println(list);
       return list;
    }
    @RequestMapping("tap")
    @ResponseBody
    public Object tap(@RequestParam("id")  Integer id,@RequestParam("tapname")  String num){

        return iTeacher.tap(id,null,num);
    }
    @RequestMapping("savetap")
    @ResponseBody
    public Object savetap(@RequestParam("id")  Integer id,@RequestParam("time")  String time,@RequestParam("tapname")  String tapname){

        return iTeacher.tap(id,time,tapname);
    }
}
