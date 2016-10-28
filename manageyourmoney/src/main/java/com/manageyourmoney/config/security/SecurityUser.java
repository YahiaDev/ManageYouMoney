package com.manageyourmoney.config.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.manageyourmoney.dto.Profile;

public class SecurityUser extends User {
	private Integer id;

	private Profile profile;

	public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public SecurityUser(Integer id, String username, String password, Profile profile,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.id = id;
		this.profile = profile;
	}

	public Integer getId() {
		return id;
	}

	public Profile getProfile() {
		return profile;
	}

}
