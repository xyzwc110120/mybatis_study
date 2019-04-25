package com.cyx.mybatis._14_ehcache;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EhCacheMapperTest {

    @Test
    @DisplayName("测试 EhCache 缓存")
    void testGetMemberList() throws InterruptedException {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(EhCacheMapper.class).getMemberList();
        }
        // 使线程沉睡 3 秒，让 EhCache 缓存中的对象超过最大空闲时间
        Thread.sleep(3000);
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(EhCacheMapper.class).getMemberList();
        }
    }

}
