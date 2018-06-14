package com.neo.service;

import com.github.pagehelper.PageInfo;
import com.neo.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public User findUserById(long id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);

    PageInfo<User> getUser(int pageNum, int pageSize);

    void deleteUser(long id);

    void updateUser(User user);

    List<User> selectUserList(String userName,Integer page,Integer rows);

    int getUserCount(String userName);
}
