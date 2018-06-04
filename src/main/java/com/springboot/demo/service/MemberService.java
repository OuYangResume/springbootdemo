package com.springboot.demo.service;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.model.bean.Member;

/**
 * @Author :Administrator
 * @Date:Created by 16:59 on 2018/6/4.
 * @Description:
 */
public interface MemberService {
    Member getMemberById(Integer id);
    PageInfo<Member> getMemberList(int pageNum, int pageSize);
}
