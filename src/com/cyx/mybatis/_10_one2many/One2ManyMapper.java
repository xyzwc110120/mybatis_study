package com.cyx.mybatis._10_one2many;

import com.cyx.mybatis.domain.Department;

import java.util.List;

public interface One2ManyMapper {

    List<Department> getDepartmentList();

}
