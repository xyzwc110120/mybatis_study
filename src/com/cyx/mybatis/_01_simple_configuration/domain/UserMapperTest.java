package com.cyx.mybatis._01_simple_configuration.domain;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import lombok.Cleanup;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {

    // MyBatis 全局配置文件字节流
    private static InputStream MYBATIS_CONFIG_STREAM = null;


    static {
        try {
            // MyBatis 包含一个名叫 Resources 的工具类，它包含一些实用方法，可使从 classpath 或其他位置加载资源文件更加容易。
            // Resources 工具类，这个类在 org.apache.ibatis.io 包中，会帮助你从类路径（classpath 路径）下、文件系统或一个 web URL 中加载资源文件。
            // 获取 MyBatis 全局配置文件。
            MYBATIS_CONFIG_STREAM = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("获取指定用户信息")
    void testGetUserById() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 通过全局配置文件创建 SqlSessionFactory 对象，好比 DataSource。
        SqlSessionFactory factory = builder.build(MYBATIS_CONFIG_STREAM);
        // 创建 SqlSession 对象，好比是 Connection。
        SqlSession session = factory.openSession();
        // 具体的操作，该类包含所有执行语句、提交或回滚事务和获取映射器实例的方法。
        User user = session.selectOne("com.cyx.mybatis._01_simple_configuration.domain.UserMapper.getUserById", 1L);
        // 关闭 SqlSession 对象
        session.close();
        System.out.println(user);
    }

    @Test
    @DisplayName("获取所有用户信息")
    void testGetUserList() {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(MYBATIS_CONFIG_STREAM);
        SqlSession session = factory.openSession();
        List<User> userList = session.selectList("com.cyx.mybatis._01_simple_configuration.domain.UserMapper.getUserList");
        session.close();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    @DisplayName("修改指定 id 的 user 信息")
    void testUpdateUserById() {
        User user = new User(2L, "root", "123456");
        @Cleanup
        SqlSession session = MyBatisUtil.getSqlSession();
        session.update("com.cyx.mybatis._01_simple_configuration.domain.UserMapper.updateUserById", user);

        /* 注意，因为创建 SqlSession 对象的时候，选择的是手动提交事务，所以如果我们不手动提交事务，则 sql 不会执行成功 */
        // 手动提交事务
        session.commit();
    }

    @Test
    @DisplayName("删除指定 id 的 user")
    void testDeleteUserById() {
        @Cleanup
        SqlSession session = MyBatisUtil.getSqlSession();
        session.delete("com.cyx.mybatis._01_simple_configuration.domain.UserMapper.deleteUserById", 2L);
        session.commit();
    }

    @Test
    @DisplayName("插入一条 user 信息，并获取自动生成的主键值")
    void testInsertUser() {
        User user = new User(null, "root", "123456");
        System.out.println(user);

        @Cleanup
        SqlSession session = MyBatisUtil.getSqlSession();
        session.insert("com.cyx.mybatis._01_simple_configuration.domain.UserMapper.insertUser", user);
        session.commit();

        System.out.println(user);
    }

}