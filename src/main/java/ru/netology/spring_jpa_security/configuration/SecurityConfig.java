package ru.netology.spring_jpa_security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("alexey").password("{noop}123").authorities("READ")
                .and()
                .withUser("Anton").password("{noop}Antonov").authorities("WRITE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and()
                .authorizeRequests().antMatchers("/persons/by-data").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/by-age").hasAuthority("READ")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }

}
