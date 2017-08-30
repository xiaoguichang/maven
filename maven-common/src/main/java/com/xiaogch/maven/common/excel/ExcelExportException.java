package com.xiaogch.maven.common.excel;

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
