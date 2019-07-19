package com.tk.passage.apis;


import com.tk.passage.dao.MenuDao;
import com.tk.passage.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "menu")
@RestController
public class MenuController {

    @Autowired
    private MenuDao menuDao;



    

    @RequestMapping(value = "/getMenu")
    public Object getMenu(){
        List menuList = menuDao.getMenu();
        return menuList;

    }

    @PostMapping(value = "/addMenu")
    public void addMenu(@RequestBody Menu menu){
        menuDao.addMenu(menu);
    }

}
