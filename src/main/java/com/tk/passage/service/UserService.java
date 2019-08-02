package com.tk.passage.service;

import com.tk.passage.pojo.ResponseData;
import com.tk.passage.pojo.Role;
import com.tk.passage.pojo.User;

public interface UserService {


    public User findByUserName(String username);

    public ResponseData login(User user);

    public Role findByRoleId(Integer id);

}
