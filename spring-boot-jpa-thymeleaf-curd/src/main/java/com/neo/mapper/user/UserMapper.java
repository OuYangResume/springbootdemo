package com.neo.mapper.user;

import com.neo.entity.User;
import org.apache.ibatis.annotations.Param;
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
     * 查询所有user数据
     *
     * @return
     */
    List<User> findAlluser();

    void updeteUser(User user);

    /**
     * 模糊user数据
     *
     * @return
     */
    List<User> selectUserList(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize, @Param("userName") String userName);

    /**
     * 获取user的总数
     */
    int getUserCount(@Param("userName") String userName);
}
