package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.jwtfilter.AuthFilter;

import javax.servlet.Filter;
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class CricAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricAppApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<Filter> jwtFilter() {
		FilterRegistrationBean<Filter> bean =
				new FilterRegistrationBean<Filter>();
		bean.setFilter(new AuthFilter());
		bean.addUrlPatterns("/api/v1/*");
		
		return bean;
	}
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//	    return new WebMvcConfigurer() {
//	        @Override
//			public
//	        void addCorsMappings(CorsRegistry registry) {
//	            registry.addMapping("/**")
//	                    .allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE","OPTIONS").allowedHeaders("Authorization")
//	                    .exposedHeaders("Authorization");
//	        }
//	    };
//	}
}
