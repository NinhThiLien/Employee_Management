package com.hrsmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.hrsmanager.authentication.EmployeeService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(employeeService);
		/*auth
		.inMemoryAuthentication()
			.withUser("honganh").password("20002000").roles("USER").and()
			.withUser("lien").password("20000000").roles("ADMIN");*/
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/","/login","/logout", "/profile").permitAll();
		/*http.authorizeRequests().antMatchers("/profile").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");*/
		http.authorizeRequests().and().formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/profile")
				.failureUrl("/login?error=true")
				.usernameParameter("email")
				.passwordParameter("password")
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessUrl");
	}
}
