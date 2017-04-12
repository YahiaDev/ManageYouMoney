package com.manageyourmoney.mongodb.document;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.manageyourmoney.dto.Profile;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "user")
public class UserDocument {
	@Id
	private String id;

	// @NotEmpty
	private String email;

	@JsonIgnore
	private String password;

	private String firstName;

	private String lastName;

	private Date birthDate;

	// @NotEmpty
	private List<String> authorities;

	@JsonIgnore
	private String secretKey;

	private Profile profile;

	@PersistenceConstructor
	public UserDocument(String id, String email, String password, List<String> authorities, String secretKey,
			Profile profile) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.secretKey = secretKey;
		this.profile = profile;
	}

	public UserDocument() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getFirstName() {
		return firstName;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
