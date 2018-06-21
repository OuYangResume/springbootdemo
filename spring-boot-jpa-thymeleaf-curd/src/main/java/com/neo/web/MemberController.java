package com.neo.web;

import com.alibaba.fastjson.JSON;
import com.neo.entity.Member;
import com.neo.entity.enums.Gender;
import com.neo.mapper.rbac.MemberMapper;
import com.neo.service.MemberService;
import static org.apache.commons.lang.StringUtils.isEmpty;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
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

    @Autowired
    MemberMapper memberMapper;
    @RequestMapping(value = "/getAll")
    public String getAll(){
        List<Member> member=memberService.findAll();
        return  JSON.toJSONString(member);
    }
    /**
     * 注册
     */
    @RequestMapping(value = "/reg")
    public String doReg(String realName, String userName, String passWord, String code){
        HashMap megss=new HashMap();
        if (isEmpty(code)) {
           megss.put("error","验证码不能为空");
        }
//        else if(!code.equalsIgnoreCase(verifyCode)){
//            megss.put("error","验证码错误");
//        }
        else if(memberMapper.findByUserName(userName)!=null){
            megss.put("error","该用户存在");
        }
        if(megss.size()>0){
            return JSON.toJSONString(megss);
        }else {
            Member member=new Member();
            member.setRealName(realName);
            member.setGender(Gender.BOY);
            member.setUserName(userName);
            member.setPassword(DigestUtils.sha256Hex(passWord));
            member.setTelephone("1221316546");
            member.setEmail(userName + "@qq.com");
            member.setHiredate(new Date());
            member.setStatus(true);
            int a=  memberService.save(member);
            if (a>0){
                megss.put("success","注册成功");
            }
        }
        return  JSON.toJSONString(megss);
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/login")
    public String login(String userName,String password,HttpSession session){
        HashMap megss =new HashMap();
        if(isEmpty(userName)||isEmpty(password)){
            megss.put("error","账号或者密码为空");
            return JSON.toJSONString(megss);
        }
        Member member=memberMapper.findByUserName(userName);
        if(member ==null|| !member.getStatus()){
            megss.put("error","用户不存在或者用户被禁用");
            return JSON.toJSONString(megss);
        }else if(!member.getPassword().equals(DigestUtils.sha256Hex(password))){
            megss.put("error","密码错误");
            return JSON.toJSONString(megss);
        }
        return "";
    }
    /**
     * 分页获取用户
     * @param page 当前页
     * @param rows 当前页面展示数目
     * @param userName 用户名称
     */
    @RequestMapping(value = "/getMemberList")
    public String getMemberList(String userName,Integer page,Integer rows){
        HashMap map =new HashMap();
        List<Member> members=memberService.getMemberList(userName,page,rows);
        int count =memberService.getMemberCount(userName);
        map.put("list",members);
        return JSON.toJSONString(map);
    }
}
