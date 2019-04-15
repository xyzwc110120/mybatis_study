package com.cyx.mybatis._03_mybatis_util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

// 自定义 MyBatis 工具类
public class MyBatisUtil {

    // SqlSessionFactory 对象在应用的运行期间只需要一个对象就可以
    private static SqlSessionFactory factory = null;

    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 SqlSession 对象
     */
    public static SqlSession getSqlSession() {
        return factory.openSession();
    }

    /**
     * 获取 Mapper 接口实现对象
     *
     * @param tClass Mapper 接口类对象
     * @param <T> Mapper 接口
     * @return Mapper 接口实现对象
     */
    public static <T> T getMapper(Class<T> tClass) {
        return getSqlSession().getMapper(tClass);
    }
}