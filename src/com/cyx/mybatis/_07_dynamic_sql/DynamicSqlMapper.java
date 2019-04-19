package com.cyx.mybatis._07_dynamic_sql;

import com.cyx.mybatis.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {

    // 使用动态 SQL：if 元素
    List<Product> getProductListUseIf(@Param("name") String name, @Param("brand") String brand);

    // 使用动态 SQL：choose 元素
    List<Product> getProductListUseChoose(@Param("name") String name, @Param("brand") String brand);

    // 使用动态 SQL：where 元素
    List<Product> getProductListUseWhere(@Param("name") String name, @Param("brand") String brand);

    // 使用动态 SQL：set 元素
    void updateProductUseSet(Product product);

    // 使用动态 SQL：trim 元素模仿 where 元素
    List<Product> getProductListUseTrim(@Param("name") String name, @Param("brand") String brand);

    // 使用动态 SQL：trim 元素模仿 set 元素
    void updateProductUseTrim(Product product);

    // 使用动态 SQL：foreach 元素
    List<Product> getProductListUseForeach(Long... ids);

    // 使用动态 SQL：foreach 元素遍历 Map 对象
    List<Product> getProductListByMap(@Param("paramMap") Map<String, String> paramMap);

    // 使用动态 SQL：foreach 元素批量插入
    void batchInsertProduct(@Param("productList") List<Product> productList);

}
