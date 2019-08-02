package com.tk.passage.service.impl;

import com.tk.passage.dao.RoleMapper;
import com.tk.passage.pojo.Role;
import com.tk.passage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-08-02 16:45
 **/

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    public Role selectByRoleCode(Integer roleCode){

        return roleMapper.selectByRoleCode(roleCode);
    }
}
