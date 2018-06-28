package com.neo.mapper.user;

import com.neo.entity.LngLat;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author :Administrator
 * @Date:Created by 9:35 on 2018/6/26.
 * @Description:
 */
@Repository
public interface LngLatMapper {
    /**
     * 根据userID查询 用户坐标信息
     * @param userid
     * @param type 地址类型
     * @return
     */
    List<LngLat> getLngLatList(@Param("userid") long userid,@Param("type") Integer type);

    void deleteById(@Param("userid") Long userid);

    void insertOneLngLat(LngLat lngLat);

    void updateLngLat(LngLat lngLat);
}
