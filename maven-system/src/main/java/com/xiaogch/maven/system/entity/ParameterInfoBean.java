package com.xiaogch.maven.system.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/11 16:44 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class ParameterInfoBean implements Serializable {

    private static final long serialVersionUID = 6919318265936743640L;

    private Integer id;
    private String paramKey;
    private String paramValue;
    private String description;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getParamKey() {
        return paramKey;
    }
    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }
    public String getParamValue() {
        return paramValue;
    }
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    @Override
    public String toString() {
        return "ParameterInfoBean [id=" + id + ", paramKey=" + paramKey
                + ", paramValue=" + paramValue + ", description="
                + description + ", createTime=" + createTime + ", updateTime="
                + updateTime + "]";
    }

}
