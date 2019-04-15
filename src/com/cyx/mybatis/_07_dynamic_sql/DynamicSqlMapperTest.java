package com.cyx.mybatis._07_dynamic_sql;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import com.cyx.mybatis.domain.Product;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DynamicSqlMapperTest {

    @Test
    @DisplayName("获取名称中带有“车”和品牌中带有“可以”的商品")
    void testGetProductListUseIf() {
        System.out.println(MyBatisUtil.getMapper(DynamicSqlMapper.class).getProductListUseIf("车", "可以"));
    }


    @Test
    @DisplayName("获取商品")
    void testGetProductListUseChoose() {
        System.out.println(MyBatisUtil.getMapper(DynamicSqlMapper.class).getProductListUseChoose(null, null));
    }

    @Test
    @DisplayName("测试使用 where 元素")
    void testGetProductListUseWhere() {
        System.out.println(MyBatisUtil.getMapper(DynamicSqlMapper.class).getProductListUseWhere("车", "可以"));
    }

    @Test
    @DisplayName("使用 set 元素")
    void testUpdateProductUseSet() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(DynamicSqlMapper.class).updateProductUseSet(
                    new Product(1L, null, "卡丁车", "真的快", null, null, null));
            session.commit();
        }
    }

    @Test
    @DisplayName("使用自定义元素 trim 元素模仿 where 元素")
    void testGetProductListUseTrim() {
        System.out.println(MyBatisUtil.getMapper(DynamicSqlMapper.class).getProductListUseTrim("车", "可以"));
    }

    @Test
    @DisplayName("使用自定义元素 trim 元素模仿 set 元素")
    void testUpdateProductUseTrim() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(DynamicSqlMapper.class).updateProductUseTrim(
                    new Product(2L, null, "超级游艇", "冲的飞快", null, null, null));
            session.commit();
        }
    }
}
