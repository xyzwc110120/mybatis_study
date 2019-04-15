package com.cyx.mybatis._05_parameter;

import com.cyx.mybatis.domain.Member;
import com.cyx.mybatis.domain.MemberLogin;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface MemberLoginMapper {

    // 登陆
    Member memberLogin1(MemberLogin login);

    // 登陆
    Member memberLogin2(Map<String, String> parameterMap);

    // 登陆
    Member memberLogin3(@Param("accountParam") String accountParam, @Param("passwordParam") String passwordParam);

}