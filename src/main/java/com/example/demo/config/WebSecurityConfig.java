package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created by MyPC on 2018/7/17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests().
               /* antMatchers("/task/toTaskManage").hasAuthority("TASK").
                antMatchers("/user/toUserManage").hasAuthority("USER").*/
                antMatchers("/*","/index","/login").
                permitAll().
                anyRequest().authenticated().
                and().
                formLogin().loginPage("/login").
                permitAll().
                and().
                logout().permitAll();
    }

    @Bean
//    @Override
    protected UserDetailsService userDetailsService() {
        CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService();
      /*  UserDetails user = User.withDefaultPasswordEncoder().
                username("user").
                password("123").
                roles("admin").
                build();*/
//        return  new InMemoryUserDetailsManager(user);
        return  customUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
}
