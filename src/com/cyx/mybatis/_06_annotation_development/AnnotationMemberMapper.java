package com.cyx.mybatis._06_annotation_development;

import com.cyx.mybatis.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AnnotationMemberMapper {

    /* 该注解与 Mapper 映射文件中的 insert 元素一样 */
    @Insert("INSERT INTO member (account, password, balance, create_time) VALUES (#{id}, #{account}, #{balance}, NOW())")
    /* 该注解可添加配置属性 */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertMember(Member member);

    /* 该注解与 Mapper 映射文件中的 update 元素一样 */
    @Update("UPDATE member SET account = #{account}, password = #{password}, balance = #{balance}, create_time = NOW() WHERE id = #{id}")
    void updateMemberById(Member member);

    /* 该注解与 Mapper 映射文件中的 delete 元素一样 */
    @Delete("DELETE FROM member WHERE id = #{id}")
    void deleteMemberById(Long id);

    /* 该注解与 Mapper 映射文件中的 select 元素一样 */
    @Select("SELECT id, account, password, balance, create_time FROM member")
    /* 该注解与 Mapper 映射文件中的 resultMap 元素一样 */
    @Results(id="memberMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "account", property = "account"),
            @Result(column = "password", property = "password"),
            @Result(column = "balance", property = "balance"),
            @Result(column = "create_time", property = "createTime")
    })
    List<Member> getMemberList();

    @Select("SELECT id, account, password, balance, create_time FROM member m WHERE m.id = #{id}")
    /* 引用上面方法配置的结果映射 */
    @ResultMap("memberMap")
    Member getMemberById(Long id);

}