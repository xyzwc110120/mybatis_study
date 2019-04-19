package com.cyx.mybatis._09_many2one;

import com.cyx.mybatis.domain.Product;

import java.util.List;

public interface Many2OneMapper {

    Product getProductById1(Long id);

    Product getProductById2(Long id);

    List<Product> getProductList1();

    List<Product> getProductList2();

    List<Product> getProductList3();

    List<Product> getProductList4();

    List<Product> getProductList5();

}
