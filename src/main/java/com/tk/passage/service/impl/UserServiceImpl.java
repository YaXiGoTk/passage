package com.tk.passage.service.impl;


import com.tk.passage.dao.MenuDao;
import com.tk.passage.dao.RoleMapper;
import com.tk.passage.dao.UserMapper;
import com.tk.passage.pojo.ResponseData;
import com.tk.passage.pojo.Role;
import com.tk.passage.pojo.User;
import com.tk.passage.service.UserService;
import com.tk.passage.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-08-02 10:42
 **/
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserMapper userDao;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public Role findByRoleId(Integer id) {
        return roleMapper.selectByRoleCode(id);
    }


    @Override
    public ResponseData login(User user) {
        Map reslt = new HashMap();
        try {
            String token = JwtUtil.generateJwt(user);


            reslt.put("user", user.getUsername());
            reslt.put("token", token);


            return new ResponseData(200,"success",reslt);

        }catch (AuthenticationException e){
            reslt.put("user", user.getUsername());
            reslt.put("reason", e.getMessage());
            return new ResponseData(400,"faild",reslt);
        }
    }

}
