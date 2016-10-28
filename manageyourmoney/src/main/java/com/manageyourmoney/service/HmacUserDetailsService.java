package com.manageyourmoney.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.manageyourmoney.config.security.SecurityUser;
import com.manageyourmoney.dto.UserDTO;
import com.manageyourmoney.mock.MockUsers;

@Component
public class HmacUserDetailsService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDTO userDTO = MockUsers.findByUsername(username);
		if (userDTO == null) {
			throw new UsernameNotFoundException("User " + username + " not found");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		if (!userDTO.getAuthorities().isEmpty()) {
			for (String authority : userDTO.getAuthorities()) {
				authorities.add(new SimpleGrantedAuthority(authority));
			}
		}

		return new SecurityUser(userDTO.getId(), userDTO.getLogin(), userDTO.getPassword(), userDTO.getProfile(),
				authorities);
	}
}
