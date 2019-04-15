package com.cyx.mybatis.domain;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Product {

    private Long id;
    private Long productTypeId;
    private String name;
    private String brand;
    private BigDecimal purchasingPrice;
    private BigDecimal originalPrice;
    private BigDecimal currentPrice;

    public Product() {
    }

    public Product(Long id, Long productTypeId, String name, String brand, BigDecimal purchasingPrice, BigDecimal originalPrice, BigDecimal currentPrice) {
        this.id = id;
        this.productTypeId = productTypeId;
        this.name = name;
        this.brand = brand;
        this.purchasingPrice = purchasingPrice;
        this.originalPrice = originalPrice;
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productTypeId=" + productTypeId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", purchasingPrice=" + purchasingPrice +
                ", originalPrice=" + originalPrice +
                ", currentPrice=" + currentPrice +
                '}';
    }
}