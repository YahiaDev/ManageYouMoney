package com.manageyourmoney.config.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.manageyourmoney.config.security.hmac.HmacUtils;

/**
 * @author Yahia AMMAR
 *
 */
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

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// String allowedHeaders = HmacUtils.X_TOKEN_ACCESS + "," +
		// HmacUtils.X_SECRET + ","
		// + HttpHeaders.WWW_AUTHENTICATE;
		// registry.addMapping("/api/**").allowedOrigins("http://localhost:8070");
		// .allowedMethods("PUT", "DELETE", "GET",
		// "POST").allowedHeaders(allowedHeaders)
		// .exposedHeaders(allowedHeaders);
		// .allowCredentials(false).maxAge(3600);

		/*String allowedHeaders = HmacUtils.X_TOKEN_ACCESS + " ," + HmacUtils.X_SECRET + " ,"
				+ HttpHeaders.WWW_AUTHENTICATE + " ," + HmacUtils.X_DIGEST + ", " + HmacUtils.X_ONCE + ", "
				+ HmacUtils.AUTHENTICATION;

		String allowedMethods = "POST, GET, OPTIONS, DELETE, PUT, HEAD";

		registry.addMapping("/api/**").allowedHeaders(allowedHeaders).allowedMethods(allowedMethods)
				.allowCredentials(true).allowedOrigins("*");*/
	}

}
