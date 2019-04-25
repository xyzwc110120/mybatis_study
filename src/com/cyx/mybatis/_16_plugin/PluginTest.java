package com.cyx.mybatis._16_plugin;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PluginTest {

    @Test
    @DisplayName("测试字符大小写")
    void testGetUUserList() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            System.out.println(session.getMapper(PluginMapper.class).getTUserList());
        }
    }

}
