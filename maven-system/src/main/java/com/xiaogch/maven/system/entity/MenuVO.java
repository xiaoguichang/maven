package com.xiaogch.maven.system.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class MenuVO implements Serializable {

    private Integer menuId;
    private String menuName;
    private String menuType;
    private String menuEntity;
    private List<MenuVO> childMenus;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuEntity() {
        return menuEntity;
    }

    public void setMenuEntity(String menuEntity) {
        this.menuEntity = menuEntity;
    }

    public List<MenuVO> getChildMenus() {
        return childMenus == null ? Collections.emptyList() : childMenus;
    }

    public void setChildMenus(List<MenuVO> childMenus) {
        this.childMenus = childMenus;
    }
}
