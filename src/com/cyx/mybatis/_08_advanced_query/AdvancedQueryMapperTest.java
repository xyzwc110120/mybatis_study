package com.cyx.mybatis._08_advanced_query;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AdvancedQueryMapperTest {

    @Test
    @DisplayName("测试高级查询")
    void testGetProductList() {
        PageResult result = new PageResult(2, 2);
        ProductQuery query = new ProductQuery("车", null, new BigDecimal(10000), null);

        result.setDataList(MyBatisUtil.getMapper(AdvancedQueryMapper.class).getProductList(result.getIndex(), result.getPageSize(), query));
        result.setTotalCount(MyBatisUtil.getMapper(AdvancedQueryMapper.class).getProductTotalCount(query));

        System.out.println(result);
    }

}