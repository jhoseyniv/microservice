package com.example.atmmanagementservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ATMSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").hasAnyRole("ADMIN")
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();
        http.csrf().disable();
    }


    @Override
    public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication().withUser("admin").password("{noop}admin")
            .authorities("ROLE_ADMIN");
    }
}
