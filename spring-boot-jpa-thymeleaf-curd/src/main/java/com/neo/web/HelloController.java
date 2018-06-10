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
    /**
     * 获取用户信息
     * @param pageNum 当前页
     * @param pageSize 当前页面展示数目
     */
    @RequestMapping(value = "/getList")
    public String getlist(int pageNum,int pageSize){
        Object users=userService.getUser(pageNum,pageSize);
        return JSON.toJSONString(users);
    }
    /**
     * 修改用户信息
     * @param user userObject
     */
    @RequestMapping(value = "/updateUser")
    public void updateUser(User user) {
        userService.updateUser(user);
    }
    /**
     * 删除用户信息
     * @param id 用户的id
     */
    @RequestMapping(value = "/deleteUser")
    public void deleteUser(long id) {
        userService.deleteUser(id);
    }
    /**
     * 添加用户信息
     * @param user userObject
     */
    @RequestMapping(value = "/addUser")
    public void createUser(User user) {
        userService.save(user);
    }
}
