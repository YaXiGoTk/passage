package com.tk.passage.apis;


import com.tk.passage.pojo.ResponseData;
import com.tk.passage.pojo.User;
import com.tk.passage.service.UserService;
import com.tk.passage.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-07-29 10:21
 **/

@RestController
public class LoginController {



    @Autowired
    private UserService userService;



    @PostMapping(value = "/login")
    public Object login(@RequestBody User user){

        ResponseData responseData = userService.login(user);

        return responseData;
    }

    @PostMapping(value = "/test")
    public Object test(){


        return "test";
    }


}
