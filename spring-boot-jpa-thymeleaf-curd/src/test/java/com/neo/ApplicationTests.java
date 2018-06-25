package com.neo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @Author :Administrator
 * @Date:Created by 20:25 on 2018/6/5.
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {
        System.out.println("hello world");
    }
    @Test
    public void  testArray(){
        ArrayList<Integer> lists = new ArrayList(3);
        lists.add(12);
        lists.add(14);
        lists.add(212);
        lists.add(15);
//        lists.clear();
        logger.info("asdfasdfasdfdasfsdfas"+String.valueOf(lists.size()));

        LinkedList linkedList =new LinkedList();
        HashMap hashMap =new HashMap();
        hashMap.put("a","asdf");
        hashMap.put("a","as");
        logger.info("++++++++++"+String.valueOf(hashMap.get("a")));


        HashSet hashSet =new HashSet();

    }
}
