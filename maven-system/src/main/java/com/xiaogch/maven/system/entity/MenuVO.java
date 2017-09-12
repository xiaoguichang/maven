package com.xiaogch.maven.system.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuVO implements Serializable {

    private Integer menuId;
    private String menuName;
    private String menuEntity;
    private Integer parentMenuId;
    private List<MenuVO> childMenus = new ArrayList<>();

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

    public Integer getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }
}
