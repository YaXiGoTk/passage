package com.tk.passage.filter;

import com.tk.passage.utils.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-07-29 15:53
 **/

public class JwtFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 从http头部读取jwt
        String authHeader = httpServletRequest.getHeader("Authorization");
        // 判断是否有token
        if (authHeader == null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        String username = null;
        try {
            username = JwtUtil.verifyJwt(authHeader);
        }catch (Exception e){
            ServletOutputStream out = httpServletResponse.getOutputStream();
            out.write(e.getMessage().getBytes());
            out.flush();

        }
        if (username!=null){
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    username, null,new ArrayList<GrantedAuthority>());

            // 把请求的信息设置到UsernamePasswordAuthenticationToken details对象里面，包括发请求的ip等
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

            // 设置认证信息
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
