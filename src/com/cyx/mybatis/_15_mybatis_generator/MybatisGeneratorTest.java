package com.cyx.mybatis._15_mybatis_generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisGeneratorTest {

    @Test
    @DisplayName("测试使用 MyBatis Generator 自动生成文件")
    void testMybatisGenerator() throws Exception {
        // MBG 执行过程中的警告信息
        List<String> warningList = new ArrayList<>();
        ConfigurationParser parser = new ConfigurationParser(warningList);
        // 获取配置文件
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("generatorConfig.xml");
        Configuration configuration = parser.parseConfiguration(stream);
        // 生成代码重复时，是否覆盖代码源
        boolean override = false;
        DefaultShellCallback callback = new DefaultShellCallback(override);

        // 创建 MBG
        MyBatisGenerator generator = new MyBatisGenerator(configuration, callback, warningList);
        generator.generate(null);

        // 输出警告
        for (String warn : warningList) {
            System.out.println(warn);
        }
    }
}
