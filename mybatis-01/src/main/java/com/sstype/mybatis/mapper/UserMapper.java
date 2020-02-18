package com.sstype.mybatis.mapper;

import com.sstype.mybatis.pojo.User;

import java.util.List;

/**
 * @author zheng22t
 * @date 2020/2/18 17:25
 */
public interface UserMapper {
    /**
     * 获取所有用户
     * @return 用户集合
     */
    List<User> getAllUser();
}