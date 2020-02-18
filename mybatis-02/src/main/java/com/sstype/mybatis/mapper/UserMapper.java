package com.sstype.mybatis.mapper;

import com.sstype.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author zheng22t
 * @date 2020/2/18 17:25
 */
public interface UserMapper {
    /**
     * 获取所有用户
     */
    List<User> getAllUser();

    /**
     * 根据ID获取用户
     */
    User getUserById(int id);

    /**
     * 根据ID和用户名获取用户
     */
    User getUserByIdAndName(Map<String, Object> map);

    /**
     * 新增用户
     */
    int addUser(User user);

    /**
     * 修改用户的信息
     */
    int updateUser(User user);

    /**
     * 删除用户
     */
    int deleteUserById(int id);
}