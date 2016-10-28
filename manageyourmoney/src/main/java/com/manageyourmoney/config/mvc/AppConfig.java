package com.manageyourmoney.config.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
// @ComponentScan(basePackages = "com.manageyourmoney.*")
@ComponentScan({ "com.manageyourmoney.*" })
public class AppConfig extends WebMvcConfigurerAdapter {
	/*
	 * @Override public void addViewControllers(ViewControllerRegistry registry)
	 * { registry.addViewController("/home").setViewName("home");
	 * registry.addViewController("/").setViewName("home");
	 * //registry.addViewController("/hello").setViewName("hello");
	 * registry.addViewController("/login").setViewName("login"); }
	 */

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
