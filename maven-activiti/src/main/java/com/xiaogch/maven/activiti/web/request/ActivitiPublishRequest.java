package com.xiaogch.maven.activiti.web.request;

import org.hibernate.validator.constraints.NotEmpty;

public class ActivitiPublishRequest {

    @NotEmpty(message = "proccessName cant't be empty")
    private String proccessName;
    @NotEmpty(message = "proccessPath cant't be empty")
    private String proccessPath;

    public String getProccessName() {
        return proccessName;
    }

    public void setProccessName(String proccessName) {
        this.proccessName = proccessName;
    }

    public String getProccessPath() {
        return proccessPath;
    }

    public void setProccessPath(String proccessPath) {
        this.proccessPath = proccessPath;
    }

    @Override
    public String toString() {
        return "ActivitiPublishRequest{" +
                "proccessName='" + proccessName + '\'' +
                ", proccessPath='" + proccessPath + '\'' +
                '}';
    }
}
