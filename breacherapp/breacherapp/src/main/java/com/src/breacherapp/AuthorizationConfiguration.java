package com.src.breacherapp;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;

@Configuration
@EnableWebSecurity
public class AuthorizationConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
		
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select name,password,true from users where name=?")
		.authoritiesByUsernameQuery(
			"select name,role from users where name=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ADMIN')")
		  .and()
		  .formLogin()
	      .loginPage("/login")
	      .loginProcessingUrl("/user/authenticate")
	      .usernameParameter("name")
	      .passwordParameter("password")
	      .successHandler((req,res,auth)->{
	    	  for (GrantedAuthority authority : auth.getAuthorities()) {
	        	  if(authority.getAuthority().contains("ROLE_ADMIN")) {
	        		  res.sendRedirect("/breacherapp/admin");
	          	  } else if(authority.getAuthority().contains("ROLE_LOWADMIN")) {
	          		res.sendRedirect("/breacherapp/lowadmin");
	        	  }
	          }
	       })
	       .failureHandler((req,res,exp)->{
	           res.sendRedirect("/login");
	       })
	       .permitAll()
	       .and()
	       .logout()
	       .logoutUrl("/user/logout")
	       .permitAll()
	       .and().
	       csrf().disable();
	}
}