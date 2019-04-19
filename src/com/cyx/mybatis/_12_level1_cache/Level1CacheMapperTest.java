package com.cyx.mybatis._12_level1_cache;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import com.cyx.mybatis.domain.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Level1CacheMapperTest {

    @Test
    @DisplayName("连续查询两次 id 为 1 的用户信息，测试一级缓存")
    void testGetMemberById1() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            Member member1 = session.getMapper(Level1CacheMapper.class).getMemberById(1L);
            System.out.println(member1);
            Member member2 = session.getMapper(Level1CacheMapper.class).getMemberById(1L);
            System.out.println(member2);

            System.out.println("member1 == member2：" + (member1 == member2));
        }
    }

    @Test
    @DisplayName("创建两个 SqlSession 对象，这样就无法使用一级缓存（不同 SqlSession 对象之间不能共享一级缓存）")
    void testGetMemberById2() {
        SqlSession session1 = MyBatisUtil.getSqlSession();
        Member member1 = session1.getMapper(Level1CacheMapper.class).getMemberById(1L);
        System.out.println(member1);

        SqlSession session2 = MyBatisUtil.getSqlSession();
        Member member2 = session2.getMapper(Level1CacheMapper.class).getMemberById(1L);
        System.out.println(member2);

        System.out.println("member1 == member2：" + (member1 == member2));
    }

    @Test
    @DisplayName("清空缓存")
    void testGetMemberById3() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            Member member1 = session.getMapper(Level1CacheMapper.class).getMemberById(1L);
            System.out.println(member1);
            // 清空缓存
            session.clearCache();
            Member member2 = session.getMapper(Level1CacheMapper.class).getMemberById(1L);
            System.out.println(member2);

            System.out.println("member1 == member2：" + (member1 == member2));
        }
    }

}
