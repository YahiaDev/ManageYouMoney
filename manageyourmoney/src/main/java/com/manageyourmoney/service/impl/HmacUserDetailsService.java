package com.manageyourmoney.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.manageyourmoney.config.security.SecurityUser;
import com.manageyourmoney.mongodb.document.UserDocument;


/**
 * @author Yahia AMMAR
 *
 */
@Component
public class HmacUserDetailsService implements UserDetailsService {

	@Autowired
	UserServiceImpl userService;

	@Override
	public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {

		UserDocument userDTO = userService.getUserByLogin(userLogin);
		if (userDTO == null) {
			throw new UsernameNotFoundException("User " + userLogin + " not found");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		if (userDTO.getAuthorities() != null && !userDTO.getAuthorities().isEmpty()) {
			for (String authority : userDTO.getAuthorities()) {
				authorities.add(new SimpleGrantedAuthority(authority));
			}
		}

		return new SecurityUser(userDTO.getId(), userDTO.getLogin(), userDTO.getPassword(), userDTO.getFirstName(),
				userDTO.getLastName(), userDTO.getProfile(), authorities);
	}
}
