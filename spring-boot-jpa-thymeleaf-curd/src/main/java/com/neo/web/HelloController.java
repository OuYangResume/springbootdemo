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
    @RequestMapping(value = "/getAllList")
    public String getAllList(){
        List<User> users=userService.getUserList();
        return JSON.toJSONString(users);
    }
    @RequestMapping(value = "/getList")
    public String getlist(int pageNum,int pageSize){
        Object users=userService.getUser(pageNum,pageSize);
        return JSON.toJSONString(users);
    }
}
