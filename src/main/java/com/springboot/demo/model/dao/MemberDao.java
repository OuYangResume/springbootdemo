package com.springboot.demo.model.dao;

import com.springboot.demo.model.bean.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author :Administrator
 * @Date:Created by 15:06 on 2018/6/4.
 * @Description: @Repository用于标注数据访问组件
 */
@Repository
public interface MemberDao {
    Member getMemberById(Integer id);
    List<Member> getMemberList();
    int add(Member member);
    int delete(Integer id);
}
