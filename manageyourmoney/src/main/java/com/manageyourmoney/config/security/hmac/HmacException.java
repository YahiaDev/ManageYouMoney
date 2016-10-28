package com.manageyourmoney.config.security.hmac;

public class HmacException extends Exception {

	public HmacException(String message) {
		super(message);
	}

	public HmacException(String message, Throwable throwable) {
		super(message, throwable);
	}
}