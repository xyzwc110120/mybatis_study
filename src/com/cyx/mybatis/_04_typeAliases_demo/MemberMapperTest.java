package com.cyx.mybatis._04_typeAliases_demo;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import com.cyx.mybatis.domain.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberMapperTest {

    @Test
    @DisplayName("获取指定 id 的 member 信息")
    void testGetMemberById() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            Member member = session.selectOne("com.cyx.mybatis._04_typeAliases_demo.MemberMapper.getMemberById", 3L);
            System.out.println(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("获取所有 member 信息")
    void testGetMemberList() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            List<Member> memberList = session.selectList("com.cyx.mybatis._04_typeAliases_demo.MemberMapper.getMemberList");
            for (Member member : memberList) {
                System.out.println(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName(" 修改指定 id 的 member 信息 ")
    void testUpdateMemberById() {
        Member member = new Member(1L, "Tom", "123", 250);

        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            MemberMapper memberMapper = session.getMapper(MemberMapper.class);
            memberMapper.updateMemberById(member);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}