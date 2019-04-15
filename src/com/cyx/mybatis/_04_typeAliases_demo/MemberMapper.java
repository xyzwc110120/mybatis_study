package com.cyx.mybatis._04_typeAliases_demo;

import com.cyx.mybatis.domain.Member;

public interface MemberMapper {

    // 修改指定 id 的 member 信息
    void updateMemberById(Member member);

}
