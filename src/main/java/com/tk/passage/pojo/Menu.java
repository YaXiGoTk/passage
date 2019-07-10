package com.tk.passage.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-07-10 09:24
 **/

public class Menu {
    private Integer id;
    private String name;
    private String url;
    private String icon;
    private Integer parentid;
    private List<Menu>child;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}
