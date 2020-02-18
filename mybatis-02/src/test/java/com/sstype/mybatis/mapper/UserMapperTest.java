package com.sstype.mybatis.mapper;

import com.sstype.mybatis.pojo.User;
import com.sstype.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zheng22t
 * @date 2020/2/18 17:37
 */
public class UserMapperTest {
    @Test
    public void getUserById() {
        //获取 SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        //获取 Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //查询
        User user = mapper.getUserById(1);
        System.out.println(user);
        //关闭连接
        sqlSession.close();
    }

    @Test
    public void getUserByIdAndName() {
        //获取 SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        //获取 Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //查询
        //        User user = mapper.getUserByIdAndName(1,"user001");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("username", "user001");
        User user = mapper.getUserByIdAndName(map);
        System.out.println(user);
        //关闭连接
        sqlSession.close();
    }

    @Test
    public void addUser() {
        //获取 SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        //获取 Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //构建User
        User user = new User();
        user.setUsername("user004");
        user.setPassword("pass004");
        //新增操作
        mapper.addUser(user);
        //提交事务
        sqlSession.commit();
        //查出来看看
        for (User u : mapper.getAllUser()) {
            System.out.println(u);
        }
        //关闭连接
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        //获取 SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        //获取 Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //构建User
        User user = new User(3, "updateuser", "updatepass");
        //新增操作
        mapper.updateUser(user);
        //提交事务
        sqlSession.commit();
        //查出来看看
        System.out.println(mapper.getUserById(3));
        //关闭连接
        sqlSession.close();
    }

    @Test
    public void deleteUserById() {
        //获取 SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        //获取 Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //删除用户
        mapper.deleteUserById(3);
        //提交事务
        sqlSession.commit();
        //查出来看看
        System.out.println(mapper.getUserById(3));
        //关闭连接
        sqlSession.close();
    }
}
