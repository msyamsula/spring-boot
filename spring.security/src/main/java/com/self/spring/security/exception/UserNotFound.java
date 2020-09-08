package com.self.spring.security.exception;

@SuppressWarnings("serial")
public class UserNotFound extends RuntimeException {

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	public UserNotFound() {
	}

	public UserNotFound(String message) {
		super(message);
	}

	public UserNotFound(Throwable cause) {
		super(cause);
	}

	public UserNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
