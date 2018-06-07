package com.neo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neo.entity.User;
import com.neo.repository.UserMapper;
import com.neo.repository.UserRepository;
import com.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userMapper.delete(id);
    }


    /**
     *
     * @Title: getUser
     * @Description: 从数据库中获取所有user列表
     * @param pageNum 当前页
     * @param pageSize 当前页面展示数目
     * @return
     */
    @Override
    public PageInfo<User> getUser(int pageNum, int pageSize) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList=userMapper.findByPage();
        PageInfo result =new PageInfo(userList);
        return result;
    }
}


