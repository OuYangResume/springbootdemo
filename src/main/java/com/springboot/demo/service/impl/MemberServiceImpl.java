package com.springboot.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.demo.model.bean.Member;
import com.springboot.demo.model.dao.MemberDao;
import com.springboot.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author :Administrator
 * @Date:Created by 17:00 on 2018/6/4.
 * @Description:
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;
    @Override
    public Member getMemberById(Integer id) {
        return memberDao.getMemberById(id);
    }
    /*
       * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
       * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
       * pageNum 开始页数
       * pageSize 每页显示的数据条数
       * */
    @Override
    public PageInfo<Member> getMemberList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Member> members  =memberDao.getMemberList();
        PageInfo result = new PageInfo(members);
        return  result;
    }


}
