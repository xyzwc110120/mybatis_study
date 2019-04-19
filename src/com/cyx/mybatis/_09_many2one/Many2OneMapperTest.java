package com.cyx.mybatis._09_many2one;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import com.cyx.mybatis.domain.Product;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Many2OneMapperTest {

    @Test
    @DisplayName("使用通常的点式分隔形式进行复杂属性导航来实现查询")
    void testGetProductById1() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            Product product = session.getMapper(Many2OneMapper.class).getProductById1(2L);
            System.out.println(product);
            System.out.println(product.getProductType());
        }
    }

    @Test
    @DisplayName("使用关联的嵌套 Select 查询")
    void testGetProductById2() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            Product product = session.getMapper(Many2OneMapper.class).getProductById2(2L);
            System.out.println(product);
            System.out.println(product.getProductType());
        }
    }

    @Test
    @DisplayName("N + 1 问题")
    void testGetProductList1() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(Many2OneMapper.class).getProductList1();
        }
    }

    @Test
    @DisplayName("使用关联的嵌套结果映射")
    void testGetProductList2() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            List<Product> productList = session.getMapper(Many2OneMapper.class).getProductList2();
            for (Product product : productList) {
                System.out.println(product);
                System.out.println(product.getProductType());
            }
        }
    }

    @Test
    @DisplayName("关联的嵌套结果映射，使用 columnPrefix 属性 ")
    void testGetProductList3() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            List<Product> productList = session.getMapper(Many2OneMapper.class).getProductList3();
            for (Product product : productList) {
                System.out.println(product);
                System.out.println(product.getProductType());
            }
        }
    }

    @Test
    @DisplayName(" 关联的嵌套结果映射，使用 resultMap 属性  ")
    void testGetProductList4() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            List<Product> productList = session.getMapper(Many2OneMapper.class).getProductList4();
            for (Product product : productList) {
                System.out.println(product);
                System.out.println(product.getProductType());
            }
        }
    }

    @Test
    @DisplayName(" 关联的嵌套结果映射，使用 resultMap + columnPrefix 属性  ")
    void testGetProductList5() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            List<Product> productList = session.getMapper(Many2OneMapper.class).getProductList5();
            for (Product product : productList) {
                System.out.println(product);
                System.out.println(product.getProductType());
            }
        }
    }
}
