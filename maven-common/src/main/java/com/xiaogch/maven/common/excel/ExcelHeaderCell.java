package com.shangde.dailyreport.excel;

/**
 * ProjectName: dailyreport-util <BR>
 * File name: ExcelHeaderCell.java <BR>
 * Author: guich <BR>
 * Project: dailyreport-util <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/16 14:16 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
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

