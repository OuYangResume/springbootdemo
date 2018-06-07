package com.neo.repository;

import com.neo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author :Administrator
 * @Date:Created by 16:07 on 2018/6/5.
 * @Description:
 */
@Repository
public interface UserMapper {
    void delete(long id);
    /**
     * 分页查询数据
     * @return
     */
    List<User> findByPage();
}
