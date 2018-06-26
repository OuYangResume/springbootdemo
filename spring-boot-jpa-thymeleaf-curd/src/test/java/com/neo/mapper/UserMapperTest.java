package com.neo.mapper;

import com.neo.entity.LngLat;
import com.neo.mapper.user.LngLatMapper;
import com.neo.mapper.user.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    public LngLatMapper lngLatMapper;
    @Test
    public void getUserCount(){
        String userName="";
        int count=userMapper.getUserCount(userName);
        logger.info(String.valueOf(count));
    }
    @Test
    public void getLngLatList(){
        Integer userid=11;
        Integer type=null;
        List<LngLat> lists=lngLatMapper.getLngLatList(userid,type);
        logger.info(String.valueOf(lists));
    }
    @Test
    public void insertLngLat(){
        LngLat lngLat =new LngLat();
        lngLat.setLng("125.2");
        lngLat.setLat("32.2");
        lngLat.setAddress("光谷未来城");
        lngLat.setType(1);
        lngLat.setUserid(18);
        int a= lngLatMapper.insertOneLngLat(lngLat);
        if (a>0){
            logger.info("asdfasdfasdfas"+String.valueOf(a));
        }
    }
}
