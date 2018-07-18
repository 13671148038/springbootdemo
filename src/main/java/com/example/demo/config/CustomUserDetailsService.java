package com.example.demo.config;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 2018/7/17.
 */
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("输入的username:"+username);
        User user = userDao.getUserByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
            //创建权限
           /* List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("TASK");
            authorities.add(grantedAuthority);*/
           String[] role = new String[]{"TASK"};
        UserDetails us = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder().
                username(username).
                password("123").authorities(role).build();
        return us;
    }
}
