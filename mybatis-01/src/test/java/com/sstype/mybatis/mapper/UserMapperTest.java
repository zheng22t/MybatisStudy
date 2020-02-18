package com.sstype.mybatis.mapper;

import com.sstype.mybatis.pojo.User;
import com.sstype.mybatis.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zheng22t
 * @date 2020/2/18 17:26
 */
public class UserMapperTest {
    @Test
    public void getAllUser() {
        //获取 SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        //获取 Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //查询
        List<User> users = mapper.getAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        //关闭连接
        sqlSession.close();
    }
}
