package com.manageyourmoney.config.mvc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.manageyourmoney.config.security.hmac.HmacUtils;

/**
 * @author Yahia AMMAR
 *
 */
@Component
public class CorsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String allowedHeaders = HmacUtils.X_TOKEN_ACCESS + " ," + HmacUtils.X_SECRET + " ,"
				+ HttpHeaders.WWW_AUTHENTICATE + " ," + HmacUtils.X_DIGEST + ", " + HmacUtils.X_ONCE + ", "
				+ HmacUtils.AUTHENTICATION;
		HttpServletResponse resp = (HttpServletResponse) response;
		// enable CORS doamin call
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		// enable post, get,options.. using cors domain
		resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
		// resp.setHeader("Access-Control-Max-Age", "3600");

		resp.setHeader("Access-Control-Allow-Headers",
				"Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization, "
						+ allowedHeaders);
		// Access-Control-Allow-Headers, Origin,Accept, X-Requested-With,
		// Content-Type, Access-Control-Request-Method,
		// Access-Control-Request-Headers
		// allow to add custom headers to the response
		resp.addHeader("Access-Control-Expose-Headers", allowedHeaders);

		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
