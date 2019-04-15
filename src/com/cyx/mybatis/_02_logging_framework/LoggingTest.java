package com.cyx.mybatis._02_logging_framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoggingTest {

    private static Logger logger = LogManager.getLogger(LoggingTest.class);

    @Test
    @DisplayName("测试自定义日志")
    void testLog() {
        // 若日志的输出等级为 INFO 或更低，则进行以下操作
        if (logger.isInfoEnabled()) {
            logger.info("输出日志，级别：INFO");
        }
        // 若日志的输出等级为 DEBUG 或更低，则进行以下操作
        if (logger.isDebugEnabled()) {
            logger.debug("输出日志，级别：DEBUG");
        }
        // 若日志的输出等级为 TRACE 或更低，则进行以下操作
        if (logger.isTraceEnabled()) {
            logger.trace("输出日志，级别：TRACE");
        }
    }

}
