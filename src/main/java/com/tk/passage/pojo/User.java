package com.tk.passage.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-07-29 10:23
 **/

public class User implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private String avatar;
    private Date createdate;
    private Integer roleid;
    private List<GrantedAuthority> grantedAuthorities;
    private List<Menu> menuAuthorities;

    public User(Integer id, String username, String password, String avatar, Date createdate, Integer roleid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.createdate = createdate;
        this.roleid = roleid;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(List<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    public List<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public List<Menu> getMenuAuthorities() {
        return menuAuthorities;
    }

    public void setMenuAuthorities(List<Menu> menuAuthorities) {
        this.menuAuthorities = menuAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
