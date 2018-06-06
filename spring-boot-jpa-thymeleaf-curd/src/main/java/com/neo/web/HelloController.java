package com.neo.web;

import com.neo.entity.User;
import com.neo.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class HelloController {
    @Resource
    UserService userService;

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
    @RequestMapping(value = "/getlist")
    public String getlist(){
        List<User> users=userService.getUserList();
        return JSON.toJSONString(users);
    }
}
