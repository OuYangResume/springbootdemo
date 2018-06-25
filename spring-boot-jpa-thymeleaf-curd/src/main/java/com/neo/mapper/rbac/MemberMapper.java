package com.neo.mapper.rbac;

import com.neo.entity.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author :Administrator
 * @Date:Created by 13:10 on 2018/6/11.
 * @Description:
 */
public interface MemberMapper {
    List<Member> findAll();

    int save(Member member);

    Member findByUserName(String userName);

    List<Member> getMemberList(@Param("pageNo")Integer pageNo,@Param("pageSize") Integer pageSize, @Param("userName") String userName);

    int getMemberCount( @Param("userName")String userName);
}
