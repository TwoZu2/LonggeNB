package com.sjiag.Control;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class UploadImg {



    public static Map upload( MultipartFile file) throws IOException {
        //获取项目classes/static的地址
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String fileName = file.getOriginalFilename();  //获取文件名

        // 图片存储目录及图片名称
        String url_path = "img" + File.separator + fileName;
        //图片保存路径
        String savePath = staticPath + File.separator + url_path;
        System.out.println("图片保存地址："+savePath);
        // 访问路径=静态资源路径+文件目录路径
        String visitPath ="static/" + url_path;
        System.out.println("图片访问uri："+visitPath);

        File saveFile = new File(savePath);
//        if (!saveFile.exists()){
//            saveFile.mkdirs();
//        }
//        try {
            file.transferTo(saveFile);  //将临时存储的文件移动到真实存储路径下
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Map map = new HashMap();
        //{
        //  "code": 0
        //  ,"msg": ""
        //  ,"data": {
        //    "src": "http://cdn.layui.com/123.jpg"
        //  }
        //}
        map.put("code",0);
        map.put("msg","");
        map.put("data",fileName);

        return map;

    }

}
