package com.cyx.mybatis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProductType {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}