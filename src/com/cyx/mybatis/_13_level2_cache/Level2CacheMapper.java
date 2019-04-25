package com.cyx.mybatis._13_level2_cache;

import com.cyx.mybatis.domain.Member;

import java.util.List;

public interface Level2CacheMapper {

    Member getMemberById(Long id);

    List<Member> getMemberList();

    void insertMember(Member member);

}
