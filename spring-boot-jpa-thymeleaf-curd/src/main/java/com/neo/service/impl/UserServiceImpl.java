package com.neo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neo.entity.LngLat;
import com.neo.entity.User;
import com.neo.mapper.user.LngLatMapper;
import com.neo.mapper.user.UserMapper;
import com.neo.mapper.user.UserRepository;
import com.neo.service.UserService;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LngLatMapper lngLatMapper;

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
     * @param pageNum  当前页
     * @param pageSize 当前页面展示数目
     * @return
     * @Title: getUser
     * @Description: 从数据库中获取所有user列表
     */
    @Override
    public PageInfo<User> getUser(int pageNum, int pageSize) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.findAlluser();
        PageInfo result = new PageInfo(userList);
        return result;
    }

    /**
     * @param id
     * @Description: 根据id删除用户
     */
    @Override
    @Transactional
    public void deleteUser(long id) {
        userMapper.delete(id);
        Long a =null;
        lngLatMapper.deleteById(a);
    }

    /**
     * @param user
     * @Description：修改用户的信息
     */
    @Override
    public void updateUser(User user) {
        userMapper.updeteUser(user);
    }

    /**
     * 条件查询user信息
     *
     * @param userName 用户名称
     * @param page     当前页
     * @param rows     当前页面展示数目
     */
    @Override
    public HashMap selectUserList(String userName, Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        ArrayList userInfo = new ArrayList();
        HashMap map = new HashMap();
        try {
            if (page != null) {
                if (rows != null) {
                    pageSize = rows;
                    pageNo = (page - 1) * pageSize;
                }
            }
            if (userName != null && userName.equals("") != true) {
                userName = URLDecoder.decode(userName, "UTF-8");
            }
            List<User> usersList = userMapper.selectUserList(pageNo, pageSize, userName);
            int conut = userMapper.getUserCount(userName);
            map.put("total", conut);
            for (User user : usersList) {
                HashMap userMap = new HashMap();
                long userid = user.getId();
                Integer type = null;
                List<LngLat> lngLats = lngLatMapper.getLngLatList(userid, type);
                if (lngLats.size() > 0) {
                    userMap.put("lnglat", lngLats);
                } else {
                    userMap.put("lnglat", "该用户没有坐标信息");
                }
                userMap.put("age", user.getAge());
                userMap.put("userName", user.getUserName());
                userMap.put("password", user.getPassword());
                userMap.put("id",user.getId());
                userInfo.add(userMap);
            }
            map.put("list", userInfo);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap();
        }
    }

    @Override
    public int getUserCount(String userName) {
        return userMapper.getUserCount(userName);
    }
}


