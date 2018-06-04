package com.springboot.demo.model.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author :Administrator
 * @Date:Created by 13:14 on 2018/6/4.
 * @Description: 自定义属性类,测试读取properties文件中的配置值
 */
@Component
public class PropertiesConfig {


//    @Value 读取properties文件中的配置值
    @Value("${test.user.username}")
    private String username;
    @Value("${test.user.age}")
    private String age;
    @Value("${test.user.toString}")
    private String  toString;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getToString() {
        return toString;
    }

    public void setToString(String toString) {
        this.toString = toString;
    }
}
