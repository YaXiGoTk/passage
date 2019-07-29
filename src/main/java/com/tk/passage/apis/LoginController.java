package com.tk.passage.apis;


import com.tk.passage.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-07-29 10:21
 **/

@RestController
public class LoginController {




    @PostMapping(value = "login")
    public Object login(@RequestBody User user){

        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUsername(),
                user.getPassword());


        //进行验证，这里可以捕获异常，然后返回对应信息

        //完成登录
        subject.login(usernamePasswordToken);

        return null;
    }


}
