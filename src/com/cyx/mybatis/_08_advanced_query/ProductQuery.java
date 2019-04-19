package com.cyx.mybatis._08_advanced_query;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;

import java.math.BigDecimal;

@Getter@Setter
public class ProductQuery {

    private String keyword;                 // 关键字
    private Long productTypeId;             // 商品类型 id
    private BigDecimal minCurrentPrice;     // 最低现价
    private BigDecimal maxCurrentPrice;     // 最高现价

    public ProductQuery() {
    }

    public ProductQuery(String keyword, Long productTypeId, BigDecimal minCurrentPrice, BigDecimal maxCurrentPrice) {
        this.keyword = keyword;
        this.productTypeId = productTypeId;
        this.minCurrentPrice = minCurrentPrice;
        this.maxCurrentPrice = maxCurrentPrice;
    }

    /**
     * 做字符串检查，防止传入空串
     */
    public String getKeyword() {
        return Strings.isBlank(keyword) ? null : keyword;
    }

}
