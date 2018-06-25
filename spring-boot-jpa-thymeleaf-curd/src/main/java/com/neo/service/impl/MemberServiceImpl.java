package com.neo.service.impl;

import com.neo.entity.Member;
import com.neo.entity.User;
import com.neo.mapper.rbac.MemberMapper;
import com.neo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author :Administrator
 * @Date:Created by 14:36 on 2018/6/11.
 * @Description:
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public int save(Member member) {
        return memberMapper.save(member);
    }

    @Override
    public List<Member> getMemberList(String userName, Integer page, Integer rows) {
        Integer pageNo=null;
        Integer pageSize =null;
        try {
            if(page!=null&&rows!=null){
                pageNo=(page-1)*rows;
                pageSize=rows;
            }
            if (userName !=null && userName.equals("")!=true){
                userName = URLDecoder.decode(userName,"UTF-8");
            }
            return memberMapper.getMemberList(pageNo,pageSize,userName);
        }catch(Exception e) {
            e.printStackTrace();
            return new ArrayList<Member>();
        }

    }

    @Override
    public int getMemberCount(String userName) {
        return memberMapper.getMemberCount(userName);
    }
}
