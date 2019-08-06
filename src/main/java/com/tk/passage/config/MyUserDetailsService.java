package com.tk.passage.config;


import com.tk.passage.pojo.Menu;
import com.tk.passage.pojo.User;

import com.tk.passage.service.MenuService;
import com.tk.passage.service.RoleService;
import com.tk.passage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-07-29 15:20
 **/

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库获取user
        User user = userService.findByUserName(username);
        if (user ==null){
            throw new UsernameNotFoundException("找不到该用户！");
        }
        //根据角色id获取对应的菜单
        List<Menu> menuAuthorities = menuService.getMenuByRole(user.getRoleid());
        List<GrantedAuthority> auths = new ArrayList<>();
        //获取角色名
        String roleName = roleService.selectByRoleCode(user.getRoleid()).getName();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+roleName.toUpperCase());
        auths.add(authority);
        user.setMenuAuthorities(menuAuthorities);
        user.setGrantedAuthorities(auths);
        return user;
    }
}
