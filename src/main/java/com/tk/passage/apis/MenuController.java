package com.tk.passage.apis;



import com.tk.passage.dao.MenuDao;
import com.tk.passage.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuDao menuDao;



    

    @RequestMapping(value = "/getMenu")
    public Object getMenu(){
        List menuList = menuDao.getMenu();
        return menuList;

    }

    /**
     * 遍历menu和子节点
     */

    public List<Menu> parseMenuList(List<Menu> menus){


        return menus;
    }

}
