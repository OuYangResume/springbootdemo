package com.springboot.demo.model.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.demo.model.enums.Gender;

import javax.persistence.*;
import java.util.Date;



/**
 * @Author :Administrator
 * @Date:Created by 13:45 on 2018/6/4.
 * @Description: 员工表的bean @Entity说明这个class是实体类并且使用默认的orm规则，
 * 即class名即数据库表中表名，class字段名即表中的字段名
 * 如果想改变这种默认的orm规则，就要使用@Table来改变class名与
 * 数据库中表名的映射规则，@Column来改变class中字段名与db中表的字段名的映射规则
 */
@Entity
@Table(name = "sys_member")
public class Member {
  /*@Id 标注用于声明一个实体类的属性映射为数据库的主键列
  @GeneratedValue 用于标注主键的生成策略，通过strategy 属性指定
   */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 64, nullable = false, unique = true, updatable = false)
    private String userName;

    @Column(length = 128, nullable = false)
    @JsonIgnore//json序列化的时候，忽略密码字段
    private String password;

    @Column(length = 64, nullable = false)
    private String realName;

    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 64)
    private String telephone;

    @Column(length = 128)
    private String email;

    @Column(length = 256)
    private String avatar;

    /**
     * 入职时间
     * JsonFormat时间格式化
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;

    private Boolean status = false;
//    @ManyToMany(targetEntity = Role.class)
//    @JoinTable(name = "sys_member_role",
//            joinColumns = {
//                    @JoinColumn(name = "member_id")
//            }, inverseJoinColumns = {
//            @JoinColumn(name = "role_id")
//    })
//    private List<Role> roles;


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

    public Boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", userName='" + userName + '\'' + ", password='" + password + '\'' + ", realName='" + realName + '\'' + ", gender=" + gender + ", telephone='" + telephone + '\'' + ", email='" + email + '\'' + ", avatar='" + avatar + '\'' + ", hiredate=" + hiredate + ", status=" + status + '}';
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

}
