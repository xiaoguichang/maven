package com.xiaogch.maven.common.db.bean;

import java.util.List;

public class PagedList<T> {

    private List<T> data;
    private PagedInfoBean pagedInfo;

    public PagedList() {

    }

    public PagedList(PagedInfoBean pagedInfo , List<T> data) {
        this.pagedInfo = pagedInfo;
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PagedInfoBean getPagedInfoBean() {
        return pagedInfo;
    }

    public void setPagedInfo(PagedInfoBean pagedInfo) {
        this.pagedInfo = pagedInfo;
    }
}
