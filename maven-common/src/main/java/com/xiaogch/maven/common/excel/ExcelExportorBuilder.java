package com.shangde.dailyreport.excel;

import java.util.List;

/**
 * ProjectName: dailyreport-util <BR>
 * File name: ExcelExportorBuilder.java <BR>
 * Author: guich <BR>
 * Project: dailyreport-util <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/16 14:41 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class ExcelExportorBuilder {

    private ExcelExportor excelExportor;

    public ExcelExportorBuilder() {
        excelExportor = new ExcelExportor();
    }

    public ExcelExportorBuilder buildWithFilePath(String filePath) {
        excelExportor.setFilePath(filePath);
        return this;
    }

    public ExcelExportorBuilder buildWithExcelName(String excelName) {
        excelExportor.setExcelName(excelName);
        return this;
    }

    public ExcelExportorBuilder buildWithRowHeight(short rowHeight) {
        excelExportor.setRowHeight(rowHeight);
        return this;
    }

    public ExcelExportorBuilder buildWithExcelHeaderCells(List<ExcelHeaderCell> excelHeaderCells) {
        excelExportor.setExcelHeaderCells(excelHeaderCells);
        return this;
    }


    public ExcelExportor build() {
        excelExportor.init();
        return excelExportor;
    }
}
