package com.manageyourmoney.config.security.hmac;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

import com.manageyourmoney.config.security.XAuthTokenFilter;

public class HmacSecurityConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
	private HmacRequester hmacRequester;

	public HmacSecurityConfigurer(HmacRequester hmacRequester) {
		this.hmacRequester = hmacRequester;
	}

	@Override
	public void configure(HttpSecurity builder) throws Exception {
		HmacSecurityFilter hmacSecurityFilter = new HmacSecurityFilter(hmacRequester);

		// Trigger this filter before SpringSecurity authentication validator
		builder.addFilterBefore(hmacSecurityFilter, XAuthTokenFilter.class);
	}

}
