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
}
