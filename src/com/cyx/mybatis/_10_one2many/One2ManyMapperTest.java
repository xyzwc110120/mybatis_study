package com.cyx.mybatis._10_one2many;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import com.cyx.mybatis.domain.Department;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class One2ManyMapperTest {

    @Test
    @DisplayName("通过一对多对象关系，获取部门列表")
    void testGetDepartmentList() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            List<Department> departmentList = session.getMapper(One2ManyMapper.class).getDepartmentList();
            for (Department department : departmentList) {
                System.out.println(department);
                System.out.println(department.getEmployeeList());
            }
        }
    }

}
