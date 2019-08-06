package com.tk.passage.filter;

import com.tk.passage.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.auth.login.LoginException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-07-29 15:53
 **/

public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 从http头部读取jwt
        String authHeader = httpServletRequest.getHeader("Authorization");
        String uri = httpServletRequest.getRequestURI();
        if ("/login".equals(uri)){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        // 判断是否有token
        if (authHeader == null || "null".equals(authHeader)) {
            try {
                throw new LoginException("no token");
            } catch (LoginException e) {
                e.printStackTrace();
            }
            return;
        }
        if ( SecurityContextHolder.getContext().getAuthentication()==null){
            httpServletResponse.getWriter().print("登录超时请重新登录");
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        Map user = null;
        try {
            user = JwtUtil.verifyJwt(authHeader);
        }catch (Exception e){
            ServletOutputStream out = httpServletResponse.getOutputStream();
            out.write(e.getClass().getSimpleName().getBytes());
            out.flush();
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
