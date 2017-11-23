package com.manageyourmoney.config.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



/**
 * @author Yahia AMMAR
 *
 */
public class XAuthTokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
	//private AuthenticationService authenticationService;

	public XAuthTokenConfigurer() {
		//this.authenticationService = authenticationService;
	}

	@Override
	public void configure(HttpSecurity builder) throws Exception {
		//XAuthTokenFilter xAuthTokenFilter = new XAuthTokenFilter(authenticationService);
		
		XAuthTokenFilter xAuthTokenFilter = new XAuthTokenFilter();

		// Trigger this filter before SpringSecurity authentication validator
		builder.addFilterBefore(xAuthTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
