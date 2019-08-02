package com.tk.passage.service.impl;

import com.tk.passage.dao.MenuDao;
import com.tk.passage.pojo.Menu;
import com.tk.passage.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-08-02 16:35
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getMenuByRole(Integer roldid) {
        return menuDao.getMenuByRole(roldid);
    }
}
