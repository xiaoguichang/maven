package com.xiaogch.maven.springmvc.entity;

import com.xiaogch.maven.springmvc.entity.PagedInfo;

import java.util.List;

public class  PagedList<T> {

    private List<T> data;
    private PagedInfo pagedInfo;

    public PagedList() {

    }

    public PagedList(PagedInfo pagedInfo , List<T> data) {
        this.pagedInfo = pagedInfo;
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PagedInfo getPagedInfo() {
        return pagedInfo;
    }

    public void setPagedInfo(PagedInfo pagedInfo) {
        this.pagedInfo = pagedInfo;
    }
}
