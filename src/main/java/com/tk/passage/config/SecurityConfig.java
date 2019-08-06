package com.tk.passage.config;

import com.tk.passage.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-07-29 14:43
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 加载用户信息
    @Autowired
    private MyUserDetailsService myUserDetailsService;


    // jwt校验过滤器，从http头部Authorization字段读取token并校验
    @Bean
    public JwtFilter jwtFilter() throws Exception {
        return new JwtFilter();
    }

    // 获取AuthenticationManager（认证管理器），可以在其他地方使用
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // 认证用户时用户信息加载配置，注入myUserDetailsService
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    // 配置http，包含权限配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 由于使用的是JWT，我们这里不需要csrf
                .csrf().disable()
                // 设置权限
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/test").hasRole("ADMIN")
                .anyRequest().authenticated();
        // 添加JWT过滤器，JWT过滤器在用户名密码认证过滤器之前
        http.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
        // 禁用缓存
//      http.headers().cacheControl();
    }


    /**
     * 暂时不加密处理
     * @return
     */
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
