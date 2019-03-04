/**
 * Project name: SpringSecurityDemo
 * Package name: dev.sanero.configuration
 * File name: WebSecurityConfig.java
 * Author: Sanero.
 * Created date: Jan 16, 2019
 * Created time: 9:41:12 AM
 */

package dev.sanero.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * @author Sanero.
 * Created date: Jan 16, 2019
 * Created time: 9:41:12 AM
 * Description: TODO - 
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private UserDetailsService userDetailsService;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
      throws Exception {
    auth.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/register").permitAll()
        .antMatchers("/").hasRole("MEMBER").antMatchers("/admin")
        .hasRole("ADMIN").and().formLogin().loginPage("/login")
        .usernameParameter("email").passwordParameter("password")
        .defaultSuccessUrl("/").failureUrl("/login?error").and()
        .exceptionHandling().accessDeniedPage("/403");
  }
}
