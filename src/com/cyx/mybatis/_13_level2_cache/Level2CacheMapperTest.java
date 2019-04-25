package com.cyx.mybatis._13_level2_cache;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import com.cyx.mybatis.domain.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Level2CacheMapperTest {

    @Test
    @DisplayName("测试二级缓存")
    void testGetMemberById() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            System.out.println(session.getMapper(Level2CacheMapper.class).getMemberById(1L));
        }
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            System.out.println(session.getMapper(Level2CacheMapper.class).getMemberById(1L));
        }
    }

    @Test
    @DisplayName("测试查询 member 列表，并不使用缓存")
    void testGetMemberList() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(Level2CacheMapper.class).getMemberList();
        }
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(Level2CacheMapper.class).getMemberList();
        }
    }

    @Test
    @DisplayName("测试使用 insert 元素插入一条 member 信息，并且不刷新缓存")
    void testInsertMember() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(Level2CacheMapper.class).getMemberById(1L);
        }
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(Level2CacheMapper.class).insertMember(new Member(null, "咚咚锵", "123", 250));
            session.commit();
        }
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(Level2CacheMapper.class).getMemberById(1L);
        }
    }

}
