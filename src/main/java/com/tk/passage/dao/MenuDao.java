package com.tk.passage.dao;

import com.tk.passage.pojo.Menu;

import java.util.List;

public interface MenuDao {


    public List<Menu>getMenu();

    public void addMenu(Menu menu);
}
