package com.springboot.demo.controller;

import com.springboot.demo.model.bean.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :Administrator
 * @Date:Created by 10:48 on 2018/6/4.
 * @Description: springboot测试
 */
@RestController
//@RestController == @Controller + @ResponseBody
public class HelloController {
    @RequestMapping(value = "sayhello" ,method = RequestMethod.GET)
    public String sayhello(){
        return "Hello SpringBoot3！";
    }


    @Autowired
    private PropertiesConfig propertiesConfig;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        return propertiesConfig.getAge()+propertiesConfig.getToString();
    }
}


