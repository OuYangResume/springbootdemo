package com.neo.service.impl;

import com.neo.entity.Member;
import com.neo.mapper.rbac.MemberMapper;
import com.neo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
