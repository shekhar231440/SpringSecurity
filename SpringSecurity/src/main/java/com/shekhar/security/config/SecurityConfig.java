package com.shekhar.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("shekhar").password("654321").roles("admin");
		auth.inMemoryAuthentication().withUser("chandra").password("654123").roles("user");
	}
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
	 * }
	 */
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeHttpRequests().antMatchers("/basic/**").authenticated().and().
	 * httpBasic(); }
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.csrf().disable();		
		http
		.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/**").hasAnyRole("admin", "user")
		.antMatchers(HttpMethod.DELETE, "/**").hasRole("admin").anyRequest().authenticated().and().formLogin();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {		
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
