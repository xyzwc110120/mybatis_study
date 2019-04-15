package com.cyx.mybatis._06_annotation_development;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import com.cyx.mybatis.domain.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AnnotationMemberMapperTest {

    @Test
    @DisplayName("插入一条 member 信息")
    void testInsertMember() {
        Member member = new Member(null, "user", "user", 20);

        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(AnnotationMemberMapper.class).insertMember(member);
            System.out.println(member);
            session.commit();
        }
    }

    @Test
    @DisplayName("修改指定 id 的 member 信息")
    void testUpdateMemberById() {
        Member member = new Member(2L, "Jerry", "666", 25);

        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(AnnotationMemberMapper.class).updateMemberById(member);
            session.commit();
        }
    }

    @Test
    @DisplayName("删除指定 id 的 member 信息")
    void testDeleteMemberById() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(AnnotationMemberMapper.class).deleteMemberById(3L);
            session.commit();
        }
    }

    @Test
    @DisplayName("获取所有 member 信息")
    void testGetMemberList() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            List<Member> memberList = session.getMapper(AnnotationMemberMapper.class).getMemberList();
            for (Member member : memberList) {
                System.out.println(member);
            }
        }
    }

    @Test
    @DisplayName("获取指定 id 的 member 信息")
    void testGetMemberById() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            System.out.println(session.getMapper(AnnotationMemberMapper.class).getMemberById(5L));
        }
    }

}
