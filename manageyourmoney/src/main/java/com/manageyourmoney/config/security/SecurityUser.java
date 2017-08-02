package com.manageyourmoney.config.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.manageyourmoney.dto.Profile;

public class SecurityUser extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private Profile profile;
	private String firstName;
	private String lastName;

	public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public SecurityUser(String id, String username, String password, String firstName, String lastName, Profile profile,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.id = id;
		this.profile = profile;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public Profile getProfile() {
		return profile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
