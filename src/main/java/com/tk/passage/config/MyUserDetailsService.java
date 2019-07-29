package com.tk.passage.config;


import com.tk.passage.pojo.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-07-29 15:20
 **/

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //从数据库获取user
        User user = new User(1,s,"123456","",new Date(),1);
        return user;
    }
}
