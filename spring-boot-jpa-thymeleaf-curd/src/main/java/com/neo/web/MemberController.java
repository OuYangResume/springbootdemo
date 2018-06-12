package com.neo.web;

import com.alibaba.fastjson.JSON;
import com.neo.entity.Member;
import com.neo.service.MemberService;
import com.neo.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author :Administrator
 * @Date:Created by 14:41 on 2018/6/11.
 * @Description:
 */
@RestController
@CrossOrigin
public class MemberController {
    @Resource
    MemberService memberService;
    @RequestMapping(value = "/getAll")
    public String getAll(){
        List<Member> member=memberService.findAll();
        return  JSON.toJSONString(member);
    }
}
