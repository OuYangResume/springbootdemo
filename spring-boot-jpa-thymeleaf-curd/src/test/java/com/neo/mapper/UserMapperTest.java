package com.neo.mapper;

import com.neo.mapper.user.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author :Administrator
 * @Date:Created by 15:48 on 2018/6/14.
 * @Description: 测试userMapper
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public UserMapper userMapper;
    @Test
    public void getUserCount(String userName){
        int count=userMapper.getUserCount(userName);
        logger.info(String.valueOf(count));
    }
}
