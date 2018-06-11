package com.neo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neo.entity.enums.Gender;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author :Administrator
 * @Date:Created by 11:27 on 2018/6/11.
 * @Description: 员工
 */
@Entity
@Table(name = "sys_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false, unique = true, updatable = false)
    private String userName;

    @Column(length = 128, nullable = false)
    @JsonIgnore//json序列化的时候，忽略密码字段
    private String password;

    @Column(length = 64, nullable = false)
    private String realName;


    private Gender gender;

    @Column(length = 64)
    private String telephone;

    @Column(length = 128)
    private String email;

    @Column(length = 256)
    private String avatar;

    /**
     * 入职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;

    private Boolean status = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
