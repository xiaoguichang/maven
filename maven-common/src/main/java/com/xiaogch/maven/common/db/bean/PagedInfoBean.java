package com.xiaogch.maven.common.db.bean;

import java.io.Serializable;

public class PagedInfoBean implements Serializable {

    private int currentPageNo; //当前页面
    private int pageSize; //每页数量
    private int totalPageSize; //总页数
    private int totalRecordSize; //总数
    private int recordSize; //当前数量

    public PagedInfoBean(int totalRecordSize , int recordSize , int currentPageNo , int totalPageSize , int pageSize) {
        this.totalRecordSize = totalRecordSize;
        this.recordSize = recordSize;
        this.totalPageSize = totalPageSize;
        this.currentPageNo = currentPageNo;
        this.pageSize = pageSize;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPageSize() {
        return totalPageSize;
    }

    public void setTotalPageSize(int totalPageSize) {
        this.totalPageSize = totalPageSize;
    }

    public int getTotalRecordSize() {
        return totalRecordSize;
    }

    public void setTotalRecordSize(int totalRecordSize) {
        this.totalRecordSize = totalRecordSize;
    }

    public int getRecordSize() {
        return recordSize;
    }

    public void setRecordSize(int recordSize) {
        this.recordSize = recordSize;
    }
}
