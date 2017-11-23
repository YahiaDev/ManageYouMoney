package com.manageyourmoney.config.security.hmac;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yahia AMMAR
 *
 */
public interface HmacRequester {
	/**
	 * Check if its possible to verify the request
	 * 
	 * @param request
	 *            htp reqsuest
	 * @return true if possible, false otherwise
	 */
	Boolean canVerify(HttpServletRequest request);

	/**
	 * Get the stored secret (locally,remotely,cache,etc..)
	 * 
	 * @param iss
	 *            issuer
	 * @return secret key
	 */
	String getSecret(String iss);

	/**
	 * Is the secret encoded in base 64
	 * 
	 * @return true if encoded in base 64 , false otherwise
	 */
	Boolean isSecretInBase64();

}
