package com.cyx.mybatis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Employee {

    private Long id;
    private String departmentId;
    private String name;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", departmentId='" + departmentId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
