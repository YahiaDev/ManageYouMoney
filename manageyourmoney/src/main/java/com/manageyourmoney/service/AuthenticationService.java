package com.manageyourmoney.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.manageyourmoney.config.security.hmac.HmacException;
import com.manageyourmoney.mongodb.document.UserDocument;

/**
 * @author Yahia AMMAR
 *
 */

public interface AuthenticationService {

	UserDocument authenticate(UserDocument userDocument, HttpServletResponse response) throws HmacException;

	void logout(HttpServletRequest request);

}
