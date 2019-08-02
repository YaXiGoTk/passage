package com.tk.passage.service;

import com.tk.passage.pojo.Role;

/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-08-02 16:44
 **/

public interface RoleService {

    Role selectByRoleCode(Integer roleCode);
}
