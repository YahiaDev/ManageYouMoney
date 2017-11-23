package com.manageyourmoney.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

/**
 * @author Yahia AMMAR
 *
 */
public class XAuthTokenFilter extends GenericFilterBean {

	// private AuthenticationService authenticationService;

	public XAuthTokenFilter() {
		// this.authenticationService = authenticationService;
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		if (!request.getRequestURI().contains("/api") || request.getRequestURI().contains("/api/authenticate")) {
			filterChain.doFilter(request, response);
		} /*
			 * else {
			 * 
			 * try { String jwtHeader =
			 * request.getHeader(HmacUtils.AUTHENTICATION); String userId =
			 * HmacSigner.getJwtIss(jwtHeader);
			 * 
			 * // Retrieve user in cache //UserDocument userDTO =
			 * MockUsers.findById(userId); //Assert.notNull(userDTO,
			 * "No user found with id: " + userId);
			 * //this.authenticationService.tokenAuthentication(userDTO.getLogin
			 * ()); filterChain.doFilter(request, response); } catch
			 * (HmacException e) { e.printStackTrace(); } }
			 */

	}

}
