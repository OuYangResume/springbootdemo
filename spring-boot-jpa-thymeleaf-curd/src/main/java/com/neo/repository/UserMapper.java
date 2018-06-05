package com.neo.repository;

import org.springframework.stereotype.Repository;

/**
 * @Author :Administrator
 * @Date:Created by 16:07 on 2018/6/5.
 * @Description:
 */
@Repository
public interface UserMapper {
    void delete(long id);
}
