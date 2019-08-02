package com.tk.passage.service;

import com.tk.passage.pojo.Menu;

import java.util.List;

public interface MenuService {


    public List<Menu> getMenuByRole(Integer roldid);
}
