package com.xiaogch.maven.common.entity;

import java.io.Serializable;

public class SysParamInfoBean implements Serializable {

    private String paramCode;
    private String paramName;
    private String paramValue;
    private String paramDesc;

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }

    @Override
    public String toString() {

        return "SysParamInfoBean{ paramCode='" + paramCode + "', paramName='" + paramName + "', paramValue='" + paramValue +
                "', paramDesc='" + paramDesc + "'}";
    }
}
