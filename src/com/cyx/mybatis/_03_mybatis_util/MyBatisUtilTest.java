package com.cyx.mybatis._03_mybatis_util;

import com.cyx.mybatis._01_simple_configuration.domain.User;
import lombok.Cleanup;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyBatisUtilTest {

    @Test
    @DisplayName("测试使用自定义 MyBatisUtil 工具类")
    void testMyBatisUtil1() {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSession();
            User user = session.selectOne("com.cyx.mybatis._01_simple_configuration.domain.UserMapper.getUserById", 1L);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    @DisplayName("使用 Try-with-resources 自动关闭资源")
    void testMyBatisUtil2() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            User user = session.selectOne("com.cyx.mybatis._01_simple_configuration.domain.UserMapper.getUserById", 1L);
            System.out.println(user);
        }
    }

    @Test
    @DisplayName("使用 Lombok 中的 @Cleanup 注解，它会在当前变量不在有效范围内的时候，对其进行自动的资源回收")
    void testMyBatisUtil3() {
        @Cleanup
        SqlSession session = MyBatisUtil.getSqlSession();
        User user = session.selectOne("com.cyx.mybatis._01_simple_configuration.domain.UserMapper.getUserById", 1L);
        System.out.println(user);
    }

}