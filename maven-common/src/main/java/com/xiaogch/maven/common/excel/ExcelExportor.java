package com.shangde.dailyreport.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


/**
 * ProjectName: dailyreport-util <BR>
 * File name: ExcelExportor.java <BR>
 * Author: guich <BR>
 * Project: dailyreport-util <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/16 13:57 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class ExcelExportor {
    Logger logger = LoggerFactory.getLogger(getClass());


    private final String defaultExcelName = "Excel-1.xls";
    private final String defaultFilePath = "";
    private final String defaultSheetName = "sheet-1";

    private String filePath = defaultFilePath;
    private String excelName = defaultExcelName;
    private String sheetName = defaultSheetName;
    private short rowHeight = 12;

    private List<ExcelHeaderCell> excelHeaderCells;

    private Workbook workbook;
    private Sheet sheet;

    private boolean isHSSF = true;

    private int rowIndex = 0;

    public void init() {
        if (excelName == null) {
            excelName = defaultExcelName;
        }
        if (excelName.endsWith(".xls")) {
            isHSSF = true;
            workbook = new HSSFWorkbook();
        } else if (excelName.endsWith(".xlsx")) {
            isHSSF = false;
            workbook = new XSSFWorkbook();
        }

        sheet = workbook.createSheet(sheetName == null ? defaultSheetName : sheetName);
        Row row;
        if (isHSSF) {
            row = ((HSSFSheet)sheet).createRow(rowIndex);
        } else {
            row = ((XSSFSheet)sheet).createRow(rowIndex);
        }
        logger.info("excel rowHeight={}" , rowHeight);
        row.setHeight(rowHeight);
        int columnIndex =  0;

        for (ExcelHeaderCell excelHeaderCell : excelHeaderCells) {
            logger.info("columnIndex={} , {}" , columnIndex , excelHeaderCell);
            sheet.setColumnWidth(columnIndex , excelHeaderCell.getWidth());
            Cell cell = row.createCell(columnIndex);

            //设置单元格格式
            CellStyle cellStyle;
            if (isHSSF) {
                cellStyle = ((HSSFWorkbook)workbook).createCellStyle();
            } else {
                cellStyle = ((XSSFWorkbook)workbook).createCellStyle();
            }

            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle.setFillBackgroundColor(new HSSFColor.GREY_25_PERCENT().getIndex());
            cellStyle.setFillForegroundColor(new HSSFColor.BLACK().getIndex());

            //设置字体
            Font font;
            if (isHSSF) {
                font = ((HSSFWorkbook)workbook).createFont();
            } else {
                font = ((XSSFWorkbook)workbook).createFont();
            }

            font.setBold(true);
            cellStyle.setFont(font);
            cell.setCellStyle(cellStyle);

            //设置单元格标题
            cell.setCellType(CellType.STRING);
            cell.setCellValue(excelHeaderCell.getTitle());
            columnIndex ++;
        }
        logger.info("init rowIndex={}" , rowIndex);
        rowIndex ++;
    }

    public void wirteRowData(List<Object> rowData) throws ExcelExportException {
        if (workbook == null || sheet == null) {
            throw new ExcelExportException("please call this mothed after init()");
        }


        if (rowData == null || rowData.size() != excelHeaderCells.size()) {
            throw new ExcelExportException("rowData为空或者字段长度与表头个数不一致");
        }

        Row row;
        if (isHSSF) {
            row = ((HSSFSheet)sheet).createRow(rowIndex);
        } else {
            row = ((XSSFSheet)sheet).createRow(rowIndex);
        }

        row.setHeight(rowHeight);
        int columnIndex = 0;
        for (ExcelHeaderCell headerCell : excelHeaderCells) {
            Object data = rowData.get(columnIndex);

            Cell cell = row.createCell(columnIndex);

            CellStyle cellStyle;
            DataFormat dataFormat;
            if (isHSSF) {
                cellStyle = ((HSSFWorkbook)workbook).createCellStyle();
                dataFormat = ((HSSFWorkbook)workbook).createDataFormat();
            } else {
                cellStyle = ((XSSFWorkbook)workbook).createCellStyle();
                dataFormat = ((XSSFWorkbook)workbook).createDataFormat();
            }

            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            if (data instanceof Number) {
                //数字靠右
                cellStyle.setAlignment(HorizontalAlignment.RIGHT);
                if (isZhengShu(data)) {
                    cellStyle.setDataFormat(dataFormat.getFormat("0"));
                } else {
                    cellStyle.setDataFormat(dataFormat.getFormat("#0.00"));
                }

                cell.setCellStyle(cellStyle);
                cell.setCellValue(Double.parseDouble(data.toString()));
                cell.setCellType(CellType.NUMERIC);
            } else {
                //居中
                cellStyle.setAlignment(HorizontalAlignment.CENTER);
                cell.setCellStyle(cellStyle);
                cell.setCellType(CellType.STRING);
                cell.setCellValue(data.toString());
            }
            columnIndex ++;
        }
        rowIndex ++;
    }

    /***
     *
     * 导出文件
     * @return 导出后的Excel文件路径
     * @throws ExcelExportException
     */
    public String exportExcelToFile() throws ExcelExportException {
        if (workbook == null || sheet == null) {
            throw new ExcelExportException("please call this mothed after init()");
        }

        if (filePath == null) {
            filePath = defaultFilePath;
        }

        if (excelName == null) {
            excelName = defaultExcelName;
        }

        try (FileOutputStream fos = new FileOutputStream(filePath + excelName)) {
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            new ExcelExportException("文件" + filePath + excelName + "不存在" , e);
        } catch (IOException e) {
            new ExcelExportException("导出Excel文件到" + filePath + excelName + "出现错误" , e);
        }
        return filePath + excelName;
    }

    public void exportExcelToOutputStream(OutputStream outputStream) throws ExcelExportException {
        if (workbook == null || sheet == null) {
            throw new ExcelExportException("please call this mothed after init()");
        }

        if(outputStream == null) {
            throw new ExcelExportException("outputStream can't be null");
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            new ExcelExportException("导出Excel出现错误" , e);
        }
    }


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<ExcelHeaderCell> getExcelHeaderCells() {
        return excelHeaderCells;
    }

    public void setExcelHeaderCells(List<ExcelHeaderCell> excelHeaderCells) {
        this.excelHeaderCells = excelHeaderCells;
    }

    public short getRowHeight() {
        return rowHeight;
    }

    public void setRowHeight(short rowHeight) {
        this.rowHeight = rowHeight;
    }

    private boolean isZhengShu(Object object) {
        if (object instanceof Byte){
            return true;
        } else if (object instanceof Short) {
            return true;
        } else if (object instanceof Integer) {
            return true;
        } else if (object instanceof Long) {
            return true;
        }
        return false;
    }



}
