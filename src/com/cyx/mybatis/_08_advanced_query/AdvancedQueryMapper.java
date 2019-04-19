package com.cyx.mybatis._08_advanced_query;

import com.cyx.mybatis.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdvancedQueryMapper {

    // 获取商品列表
    List<Product> getProductList(@Param("index") Integer index, @Param("pageSize") Integer pageSize,
                                 @Param("query") ProductQuery query);

    // 获取商品总数
    Integer getProductTotalCount(@Param("query") ProductQuery query);

}
