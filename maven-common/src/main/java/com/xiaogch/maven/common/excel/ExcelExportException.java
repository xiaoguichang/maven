package com.shangde.dailyreport.excel;

/**
 * ProjectName: dailyreport-util <BR>
 * File name: ExcelExportException.java <BR>
 * Author: guich <BR>
 * Project: dailyreport-util <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/16 15:28 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class ExcelExportException extends Exception {

    public ExcelExportException() {
        super();
    }

    public ExcelExportException(String message){
        super(message);
    }

    public ExcelExportException(String message , Throwable throwable) {
        super(message , throwable);
    }
}
