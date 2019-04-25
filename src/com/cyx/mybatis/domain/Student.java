package com.cyx.mybatis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Student {

    private Long id;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
