package com.manageyourmoney.mock;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.manageyourmoney.dto.Profile;
import com.manageyourmoney.mongodb.document.UserDocument;

@SuppressWarnings("unchecked")
public class MockUsers {

	private static List<UserDocument> users = new ArrayList<>();

	private static Map<Profile, List<String>> authorities = new HashMap() {
		{
			put(Profile.ADMIN, Arrays.asList("ROLE_ADMIN", "ROLE_MANAGER", "ROLE_USER"));
			put(Profile.USER, Arrays.asList("ROLE_USER"));
			put(Profile.MANAGER, Arrays.asList("ROLE_MANAGER", "ROLE_USER"));
		}
	};

	public static void mock() {
		UserDocument admin = new UserDocument();
		admin.setId("1");
		admin.setEmail("test@test.com");
		admin.setProfile(Profile.ADMIN);
		admin.setPassword("yahia");
		admin.setAuthorities(authorities.get(admin.getProfile()));
		users.add(admin);

		UserDocument user = new UserDocument();
		user.setId("2");
		user.setEmail("user");
		user.setProfile(Profile.USER);
		user.setPassword("frog");
		user.setAuthorities(authorities.get(user.getProfile()));
		users.add(user);

		UserDocument manager = new UserDocument();
		manager.setId("3");
		manager.setEmail("manager");
		manager.setProfile(Profile.MANAGER);
		manager.setPassword("frog");
		manager.setAuthorities(authorities.get(manager.getProfile()));
		users.add(manager);

	}

	public static List<UserDocument> getUsers() {
		if (users.isEmpty()) {
			mock();
		}
		return users;
	}

	/**
	 * Find a user by username
	 * 
	 * @param username
	 *            username
	 * @return a UserDTO if found, null otherwise
	 */
	public static UserDocument findByUsername(String username) {
		for (UserDocument userDTO : users) {
			if (userDTO.getEmail().equals(username)) {
				return userDTO;
			}
		}
		return null;
	}

	/**
	 * Find a user by id
	 * 
	 * @param id
	 *            user id
	 * @return a UserDTO if found, null otherwise
	 */
	public static UserDocument findById(String id) {
		for (UserDocument userDTO : users) {
			if (userDTO.getId().equals(id)) {
				return userDTO;
			}
		}
		return null;
	}

	public static UserDocument findByLogin(String login) {
		for (UserDocument userDTO : users) {
			if (userDTO.getEmail().equals(login)) {
				return userDTO;
			}
		}
		return null;
	}

	/**
	 * Update a given user
	 * 
	 * @param newUserDTO
	 *            new user
	 * @return updated user
	 */
	public static UserDocument update(UserDocument newUserDTO) {
		UserDocument existingUser = findById(newUserDTO.getId());
		if (existingUser != null) {
			BeanUtils.copyProperties(newUserDTO, existingUser, "password");
			existingUser.setAuthorities(authorities.get(existingUser.getProfile()));
		}
		return null;
	}

}
