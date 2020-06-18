package com.sjiag.Control;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjiag.Service.IfmanagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fmanagerModel")
public class fmanagerController {

    @Resource
    IfmanagerService service;
    /**
     * 考勤
     */
    //查询记录
    @RequestMapping("/tamperQueryAll")
    @ResponseBody
    public String fmanagerTamperQueryAll(Model model,Integer userId) throws JsonProcessingException {
        List<Map>  kaoqins=service.kaoqinFmanagerService(userId);
        ObjectMapper mapper= new ObjectMapper();
        String str=mapper.writeValueAsString(kaoqins);
        return str;
    }




}
