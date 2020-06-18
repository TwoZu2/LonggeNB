package com.sjiag.Control;

import com.sjiag.Service.ITeacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
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
        System.out.println(list);
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
}
