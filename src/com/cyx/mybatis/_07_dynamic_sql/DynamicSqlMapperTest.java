package com.cyx.mybatis._07_dynamic_sql;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import com.cyx.mybatis.domain.Product;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    @DisplayName("使用 foreach 元素")
    void testGetProductListUseForeach() {
        System.out.println(MyBatisUtil.getMapper(DynamicSqlMapper.class).getProductListUseForeach(1L, 3L, 7L));
    }

    @Test
    @DisplayName("使用 foreach 元素遍历 Map 对象")
    void testGetProductListByMap() {
        Map<String, String> param = new HashMap<String, String>() {
            {
                this.put("name", "车");
                this.put("brand", "可以");
            }
        };

        System.out.println(MyBatisUtil.getMapper(DynamicSqlMapper.class).getProductListByMap(param));
    }

    @Test
    @DisplayName("使用 foreach 元素批量插入")
    void testBatchInsertProduct() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(null, 1L, "三轮车", "至尊奢华天子驾", new BigDecimal(600000), new BigDecimal(800000), new BigDecimal(50000)));
        productList.add(new Product(null, 2L, "死飞", "可以死的更快", new BigDecimal(50000), new BigDecimal(60000), new BigDecimal(42000)));

        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            session.getMapper(DynamicSqlMapper.class).batchInsertProduct(productList);
            session.commit();
            System.out.println(productList);
        }
    }
}
