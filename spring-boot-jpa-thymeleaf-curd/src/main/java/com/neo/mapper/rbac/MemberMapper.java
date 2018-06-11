package com.neo.mapper.rbac;

import com.neo.entity.Member;

import java.util.List;

/**
 * @Author :Administrator
 * @Date:Created by 13:10 on 2018/6/11.
 * @Description:
 */
public interface MemberMapper {
    List<Member> findAll();
}
