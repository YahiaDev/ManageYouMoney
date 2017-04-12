package com.manageyourmoney.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.manageyourmoney.config.security.hmac.HmacRequester;
import com.manageyourmoney.mock.MockUsers;
import com.manageyourmoney.mongodb.document.UserDocument;

@Service
public class DefaultHmacRequester implements HmacRequester {
	@Override
	public Boolean canVerify(HttpServletRequest request) {
		return request.getRequestURI().contains("/api") && !request.getRequestURI().contains("/api/authenticate");
	}

	@Override
	public String getSecret(String iss) {
		UserDocument userDTO = MockUsers.findById(iss);
		if (userDTO != null) {
			return userDTO.getSecretKey();
		}
		return null;
	}

	@Override
	public Boolean isSecretInBase64() {
		return true;
	}
}
