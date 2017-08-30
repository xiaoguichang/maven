package com.xiaogch.maven.common.excel;

import java.util.List;

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
