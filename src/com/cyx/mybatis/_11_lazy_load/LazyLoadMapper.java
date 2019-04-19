package com.cyx.mybatis._11_lazy_load;

import com.cyx.mybatis.domain.Department;

import java.util.List;

public interface LazyLoadMapper {

    List<Department> getDepartmentList();

}
