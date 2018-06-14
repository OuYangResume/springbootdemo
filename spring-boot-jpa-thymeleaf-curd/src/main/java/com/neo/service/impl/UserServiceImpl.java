package com.neo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neo.entity.User;
import com.neo.mapper.user.UserMapper;
import com.neo.mapper.user.UserRepository;
import com.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.util.ArrayList;
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
        List<User> userList=userMapper.findAlluser();
        PageInfo result =new PageInfo(userList);
        return result;
    }
    /**
     *@Description: 根据id删除用户
     *@param id
     */
    @Override
    public void deleteUser(long id) {
        userMapper.delete(id);
    }
    /**
     * @Description：修改用户的信息
     *@param user
     */
    @Override
    public void updateUser(User user) {
        userMapper.updeteUser(user);
    }
    /**
     *条件查询user信息
     * @param page 当前页
     * @param rows 当前页面展示数目
     * @param userName 用户名称
     */
    @Override
    public List<User> selectUserList(String userName, Integer page, Integer rows) {
        Integer pageNo=null;
        Integer pageSize =null;
        try{
            if(page !=null){
                if (rows !=null){
                    pageSize =rows;
                    pageNo =(page-1)*pageSize;
                }
            }
            if (userName !=null && userName.equals("")!=true){
                userName = URLDecoder.decode(userName,"UTF-8");
            }
            return userMapper.selectUserList(pageNo,pageSize,userName);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ArrayList<User>();
        }
    }

    @Override
    public int getUserCount(String userName) {
        return userMapper.getUserCount(userName);
    }
}


