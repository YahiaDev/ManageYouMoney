package com.manageyourmoney.config.security;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.manageyourmoney.config.security.hmac.HmacRequester;
import com.manageyourmoney.config.security.hmac.HmacSecurityConfigurer;
import com.manageyourmoney.mongodb.document.UserDocument;
import com.manageyourmoney.service.UserService;

/**
 * @author Yahia AMMAR
 *
 */
@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Autowired
//	private AuthenticationService authenticationService;

	@Autowired
	private UserService userService;

	@Autowired
	private HmacRequester hmacRequester;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/modules/**/*.{js}").antMatchers("/bower_components/**").antMatchers("/assets/**")
				.antMatchers("*.{ico}").antMatchers("/modules/**/*.{html}");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new XAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class).authorizeRequests()
				.antMatchers("/api/authenticate").anonymous().antMatchers("/").anonymous().antMatchers("/api/**")
				.authenticated().and().csrf().disable().headers().frameOptions().disable().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().logout().permitAll().and()
				.apply(authTokenConfigurer()).and().apply(hmacSecurityConfigurer());
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(inMemoryUserDetailsManager(userService)).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager(UserService userService) {
		final Properties users = new Properties();
		List<UserDocument> userList = userService.getAllUser();
		for (UserDocument userDTO : userList) {
			users.put(userDTO.getLogin().toLowerCase(), userDTO.getPassword() + ",ADMIN,enabled");
		}
		return new InMemoryUserDetailsManager(users);
	}

	private HmacSecurityConfigurer hmacSecurityConfigurer() {
		return new HmacSecurityConfigurer(hmacRequester);
	}

	private XAuthTokenConfigurer authTokenConfigurer() {
		return new XAuthTokenConfigurer();
	}

}