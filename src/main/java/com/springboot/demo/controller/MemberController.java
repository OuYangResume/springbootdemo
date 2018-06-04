package com.springboot.demo.controller;

import com.springboot.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :Administrator
 * @Date:Created by 17:13 on 2018/6/4.
 * @Description:
 */
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    /**
     * 查询用户列表
     * @return
     */
    @GetMapping(value = "all")
    @ResponseBody
    public  Object getMemberList( @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                              int pageNum,
                                  @RequestParam(name = "pageSize", required = false, defaultValue = "2")
                                              int pageSize){
        return memberService.getMemberList(pageNum,pageSize);
    }
}

