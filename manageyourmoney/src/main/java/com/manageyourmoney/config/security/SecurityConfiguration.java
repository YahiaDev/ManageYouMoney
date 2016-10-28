package com.manageyourmoney.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.manageyourmoney.config.security.hmac.HmacRequester;
import com.manageyourmoney.config.security.hmac.HmacSecurityConfigurer;
import com.manageyourmoney.dto.UserDTO;
import com.manageyourmoney.mock.MockUsers;
import com.manageyourmoney.service.AuthenticationService;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private HmacRequester hmacRequester;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/modules/**/*.{js}").antMatchers("/bower_components/**").antMatchers("/assets/**")
				.antMatchers("*.{ico}").antMatchers("/modules/**/*.{html}");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/authenticate").anonymous().antMatchers("/").anonymous()
				.antMatchers("/api/**").authenticated().and().csrf().disable().headers().frameOptions().disable().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().logout().permitAll()
				.and().apply(authTokenConfigurer()).and().apply(hmacSecurityConfigurer());
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		InMemoryUserDetailsManagerConfigurer configurer = auth.inMemoryAuthentication()
				.passwordEncoder(passwordEncoder());

		for (UserDTO userDTO : MockUsers.getUsers()) {
			configurer.withUser(userDTO.getLogin()).password(passwordEncoder().encode(userDTO.getPassword()))
					.roles(userDTO.getProfile().name());
		}
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	private HmacSecurityConfigurer hmacSecurityConfigurer() {
		return new HmacSecurityConfigurer(hmacRequester);
	}

	private XAuthTokenConfigurer authTokenConfigurer() {
		return new XAuthTokenConfigurer(authenticationService);
	}

}
