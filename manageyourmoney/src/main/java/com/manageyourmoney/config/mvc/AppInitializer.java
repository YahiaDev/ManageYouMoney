package com.manageyourmoney.config.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Yahia AMMAR
 *
 */
public class AppInitializer implements WebApplicationInitializer {
	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.setServletContext(container);
		
		// ctx.register(Springse);
		// ctx.scan("my_package");

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
		
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
		
		//Added filter dynamically
        javax.servlet.FilterRegistration.Dynamic corsFilter = container.addFilter("corsfilter", CorsFilter.class);
        corsFilter.addMappingForUrlPatterns(null, true, "/*");
	}

}
