package com.touristmanagement.apigateway.exceptions;

public class TokenExpiredException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TokenExpiredException(String msg) {
		super(msg);
	}
	
	public TokenExpiredException(Exception msg) {
		super(msg);
	}


}
