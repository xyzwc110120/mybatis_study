package com.cyx.mybatis._14_ehcache;

import com.cyx.mybatis.domain.Member;

import java.util.List;

public interface EhCacheMapper {

    List<Member> getMemberList();

}
