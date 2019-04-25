package com.cyx.mybatis._16_plugin;


import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

// 来标注要对哪一个组件中的哪一个方法做拦截增强
@Intercepts(@Signature(
        // type 参数：明确指明是哪一个类。
        type = ResultSetHandler.class,
        // method 参数和 args 参数：分别指明该类中的哪一个方法，和该方法有哪些参数类型（这两个参数指定方法签名）。
        method = "handleResultSets",
        args = {Statement.class}
))
public class CustomizedInterceptor implements Interceptor {

    // 如何做增强的细节
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("进入拦截器");
        // 放行
        return invocation.proceed();
    }

    // 包装
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    // 给拦截器设置配置参数，配置可以由使用拦截器的人来给定
    @Override
    public void setProperties(Properties properties) {
    }
}
