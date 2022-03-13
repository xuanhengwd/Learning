package com.example.pojo;

import java.util.List;

/**
 * 分页查询的javabean
 */
public class PageBean<T> {
    //总记录数
    private int totalCount;

    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
