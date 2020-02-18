package com.sstype.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zheng22t
 * @date 2020/2/18 17:39
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 获取SqlSession
     */
    public static SqlSession getSession(){
        if (sqlSessionFactory == null){
            //构建 SqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return sqlSessionFactory.openSession();

    }
}