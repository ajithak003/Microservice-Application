package com.touristmanagement.place_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus
public class CustomServiceException extends RuntimeException{

	private final HttpStatus status;

    public CustomServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

	public HttpStatusCode getStatus() {
        return HttpStatusCode.valueOf(503);
    }
	
}
