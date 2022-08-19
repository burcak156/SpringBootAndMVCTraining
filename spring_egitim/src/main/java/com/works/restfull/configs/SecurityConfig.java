package com.works.restfull.configs;

import com.works.restfull.services.AdminDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final AdminDetailService adminDetailService;
    final PasswordEncoder encoder;
    //final FilterConfig filterConfig;
    final CustomFilter customFilter;

    //sql -> username -pass
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminDetailService).passwordEncoder(encoder);
       // super.configure(auth);
    }
    //role -> mapping
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
                        .antMatchers("/customer/**").hasRole("customer")
                        .antMatchers("/product/**").hasRole("product")
                        .antMatchers("/note/**").hasRole("note")
                        .and().csrf().disable().formLogin().disable();
        httpSecurity.addFilterBefore(customFilter, BasicAuthenticationFilter.class);
        httpSecurity.headers().frameOptions().disable();
    }

}
