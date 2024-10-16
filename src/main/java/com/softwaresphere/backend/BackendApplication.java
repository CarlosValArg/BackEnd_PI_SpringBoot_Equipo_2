package com.softwaresphere.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.softwaresphere.backend.config.JwtFilter;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
	FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
	registrationBean.setFilter(new JwtFilter());
	registrationBean.addUrlPatterns("/api/servicios/*");
	registrationBean.addUrlPatterns("/api/usuarios/*");
	return registrationBean;
}
	
}//class BackendApplication
