package com.tk.passage.dao;

import com.tk.passage.pojo.Menu;

import java.util.List;

public interface MenuDao {


    public List<Menu>getMenuFilterData(Menu menu);


    public List<Menu>getMenu(Menu menu);

    public void addMenu(Menu menu);


    public List<Menu>getParentMenu(Menu menu);

    public List<Menu>getMenuByRole(Integer roldid);
}


