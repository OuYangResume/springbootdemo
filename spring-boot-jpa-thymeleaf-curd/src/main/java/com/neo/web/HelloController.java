package com.neo.web;

import com.neo.entity.ExcelData;
import com.neo.entity.User;
import com.neo.service.UserService;
import com.neo.utils.ExcelUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class HelloController {
    @Resource
    UserService userService;

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = "/getAllList")
    public String getAllList() {
        List<User> users = userService.getUserList();
        return JSON.toJSONString(users);
    }

    /**
     * 获取用户信息
     *
     * @param pageNum  当前页
     * @param pageSize 当前页面展示数目
     */
    @RequestMapping(value = "/getList")
    public String getlist(int pageNum, int pageSize) {
        Object users = userService.getUser(pageNum, pageSize);
        return JSON.toJSONString(users);
    }
    /**
     * 获取用户信息
     * @param page 当前页
     * @param rows 当前页面展示数目
     * @param userName 用户名称
     * @return
     */

    @RequestMapping(value = "/selectUserList")
    public String selectUserList(String userName,Integer page,Integer rows){
        HashMap map=new HashMap();
        List<User> users=userService.selectUserList(userName,page,rows);
        int count=userService.getUserCount(userName);
        map.put("list",users);
        map.put("total",count);
        return JSON.toJSONString(map);
    }
    /**
     * 修改用户信息
     *
     * @param user userObject
     */
    @RequestMapping(value = "/updateUser")
    public void updateUser(User user) {
        userService.updateUser(user);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户的id
     */
    @RequestMapping(value = "/deleteUser")
    public void deleteUser(long id) {
        userService.deleteUser(id);
    }

    /**
     * 添加用户信息
     *
     * @param user userObject
     */
    @RequestMapping(value = "/addUser")
    public void createUser(User user) {
        userService.save(user);
    }

    /**
     * 导出excel
     */
    @RequestMapping(value = "excel/test")
    public void test(HttpServletResponse response) {
        int rowIndex = 0;
        List<User> list = userService.getUserList();
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList<>();
        titles.add("ID");
        titles.add("userName");
        titles.add("password");
        titles.add("age");
        data.setTitles(titles);
        List<List<Object>> rows = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            List<Object> row = new ArrayList<>();
            row.add(user.getId());
            row.add(user.getUserName());
            row.add(user.getPassword());
            row.add(user.getAge());
            rows.add(row);
        }
        data.setRows(rows);
        try {
            ExcelUtils.exportExcel(response, "test", data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
