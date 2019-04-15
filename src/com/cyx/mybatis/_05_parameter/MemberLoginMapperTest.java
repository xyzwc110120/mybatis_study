package com.cyx.mybatis._05_parameter;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import com.cyx.mybatis.domain.MemberLogin;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MemberLoginMapperTest {

    @Test
    @DisplayName("登陆，方式一：将多参数封装至 POJO 对象来传递")
    void testLogin1() {
        MemberLogin login = new MemberLogin("abc", "123");

        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            MemberLoginMapper loginMapper = session.getMapper(MemberLoginMapper.class);
            System.out.println(loginMapper.memberLogin1(login));
        }
    }

    @Test
    @DisplayName("登陆，方式二：将多参数封装之 Map 集合之中")
    void testLogin2() {
        /*
            HashMap 初始化：
                这里的双括号“{{}}”用来初始化，使代码简洁易读。第一层括弧实际是定义了一个匿名内部类 (Anonymous Inner Class)，
                第二层括弧实际上是一个实例初始化块 (instance initializer block)，这个块在内部匿名类构造时被执行。

            注意：此方法效率较低，在开发中不建议使用
        */
        Map<String, String> parameter = new HashMap<String, String>() {
            {
                this.put("accountMap", "abc");
                this.put("passwordMap", "123");
            }
        };

        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            System.out.println(session.getMapper(MemberLoginMapper.class).memberLogin2(parameter));
        }
    }

    @Test
    @DisplayName("登陆，方式三：使用 @Param 注解（其原理就是将注解标注的参数封装至一个 Map 集合中）")
    void testLogin3() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            System.out.println(session.getMapper(MemberLoginMapper.class).memberLogin3("abc", "123"));
        }
        /*
            注意，我们在 Mapper 接口中对应的的方法中使用的 @Param 注解，
            而在 XML 映射文件中对应的操作元素内 parameterType 属性写的是 map，
            证明 @Param 注解的原理就是将该注解标注的参数封装成一个 Map 对象。
        */
    }

}