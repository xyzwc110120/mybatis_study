package com.cyx.mybatis._08_advanced_query;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class PageResult {

    private Integer pageNo;         // 当前页
    private Integer pageSize;       // 每页显示条数

    private Integer index;          // 分页起始下标
    @Setter
    private List<?> dataList;       // 查询出的每页的结果集
    private Integer totalCount;     // 总条数
    private Integer totalPage;      // 总页数

    public PageResult(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.index = (pageNo - 1) * pageSize;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", index=" + index +
                ", dataList=" + dataList +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                '}';
    }
}
