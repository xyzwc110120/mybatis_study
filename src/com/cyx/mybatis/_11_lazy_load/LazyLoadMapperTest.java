package com.cyx.mybatis._11_lazy_load;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import com.cyx.mybatis.domain.Department;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LazyLoadMapperTest {

    @Test
    @DisplayName("测试延迟加载（懒加载）")
    void testGetDepartmentList() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            List<Department> departmentList = session.getMapper(LazyLoadMapper.class).getDepartmentList();
            for (Department department : departmentList) {
                System.out.println(department);
                System.out.println(department.getEmployeeList());
            }
        }
    }
}