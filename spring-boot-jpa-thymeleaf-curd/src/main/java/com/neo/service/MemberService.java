package com.neo.service;

import com.neo.entity.Member;

import java.util.List;

/**
 * @Author :Administrator
 * @Date:Created by 14:35 on 2018/6/11.
 * @Description:
 */
public interface MemberService {
    List<Member> findAll();

    int save(Member member);

    List<Member> getMemberList(String userName, Integer page, Integer rows);

    int  getMemberCount(String userName);
}
