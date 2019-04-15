package com.cyx.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

// @AllArgsConstructor 注解：创建一个全参构造方法
@AllArgsConstructor
@Getter
public class MemberLogin {

    private String account;
    private String password;

}
