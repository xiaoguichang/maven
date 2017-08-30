package com.xiaogch.maven.common.excel;

public class ExcelHeaderCell {
    private String title;
    private int width;

    public ExcelHeaderCell(String title, int width) {
        this.title = title;
        this.width = width;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "ExcelHeaderCell{" +
                "title='" + title + '\'' +
                ", width=" + width +
                '}';
    }
}

