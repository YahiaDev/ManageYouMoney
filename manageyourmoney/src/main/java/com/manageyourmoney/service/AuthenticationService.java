package com.manageyourmoney.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.manageyourmoney.config.security.SecurityUser;
import com.manageyourmoney.config.security.hmac.HmacException;
import com.manageyourmoney.config.security.hmac.HmacSecurityFilter;
import com.manageyourmoney.config.security.hmac.HmacSigner;
import com.manageyourmoney.config.security.hmac.HmacToken;
import com.manageyourmoney.config.security.hmac.HmacUtils;
import com.manageyourmoney.dto.LoginDTO;
import com.manageyourmoney.mock.MockUsers;
import com.manageyourmoney.mongodb.document.UserDocument;

@Service
public class AuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;// pe etre solution
														// ajoute une classe qui
														// iplemente
														// authentication
														// manager ...

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Authenticate a user in Spring Security The following headers are set in
	 * the response: - X-TokenAccess: JWT - X-Secret: Generated secret in base64
	 * using SHA-256 algorithm - WWW-Authenticate: Used algorithm to encode
	 * secret The authenticated user in set ine the Spring Security context The
	 * generated secret is stored in a static list for every user
	 * 
	 * @see MockUsers
	 * @param userDocument
	 *            credentials
	 * @param response
	 *            http response
	 * @return UserDTO instance
	 * @throws HmacException
	 */
	public UserDocument authenticate(UserDocument userDocument, HttpServletResponse response) throws HmacException {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userDocument.getLogin(), userDocument.getPassword());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Retrieve security user after authentication
		SecurityUser securityUser = (SecurityUser) userDetailsService.loadUserByUsername(userDocument.getLogin());

		// Parse Granted authorities to a list of string authorities
		List<String> authorities = new ArrayList<>();
		for (GrantedAuthority authority : securityUser.getAuthorities()) {
			authorities.add(authority.getAuthority());
		}

		// Get Hmac signed token
		Map<String, String> customClaims = new HashMap<>();
		customClaims.put(HmacSigner.ENCODING_CLAIM_PROPERTY, HmacUtils.HMAC_SHA_256);

		// Generate a random secret
		String secret = HmacSigner.generateSecret();

		HmacToken hmacToken = HmacSigner.getSignedToken(secret, String.valueOf(securityUser.getId()),
				HmacSecurityFilter.JWT_TTL, customClaims);

		// for (UserDocument userDTO : MockUsers.getUsers()) {
		// if (userDTO.getId().equals(securityUser.getId())) {
		// userDTO.setSecretKey(secret);
		// }
		// }

		// Set all tokens in http response headers

		response.setHeader(HmacUtils.X_TOKEN_ACCESS, hmacToken.getJwt());
		response.setHeader(HmacUtils.X_SECRET, hmacToken.getSecret());
		response.setHeader(HttpHeaders.WWW_AUTHENTICATE, HmacUtils.HMAC_SHA_256);

		UserDocument userDTO = new UserDocument();
		userDTO.setId(securityUser.getId());
		userDTO.setLogin(securityUser.getUsername());
		userDTO.setAuthorities(authorities);
		userDTO.setProfile(securityUser.getProfile());
		userDTO.setSecretKey(secret);
		return userDTO;
	}

	/**
	 * Logout a user - Clear the Spring Security context - Remove the stored
	 * UserDTO secret
	 */
	public void logout() {
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			// SecurityUser securityUser = (SecurityUser)
			// SecurityContextHolder.getContext().getAuthentication()
			// .getPrincipal();

			UserDocument userDTO = MockUsers
					.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
			if (userDTO != null) {
				userDTO.setSecretKey(null);
			}

		}
	}

	/**
	 * Authentication for every request - Triggered by every http request except
	 * the authentication
	 * 
	 * @see fr.redfroggy.hmac.configuration.security.XAuthTokenFilter Set the
	 *      authenticated user in the Spring Security context
	 * @param username
	 *            username
	 */
	public void tokenAuthentication(String username) {
		UserDetails details = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(details,
				details.getPassword(), details.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authToken);
	}
}
