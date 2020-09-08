package com.self.spring.security.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.self.spring.security.exception.UserNotFound;
import com.self.spring.security.exceptionResponse.SimpleErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	public GlobalExceptionHandler() {}
	
	@ExceptionHandler
	public ResponseEntity<SimpleErrorResponse> handle(UserNotFound exc){
		// create response
		SimpleErrorResponse error = new SimpleErrorResponse(
					HttpStatus.NOT_FOUND.value(),
					exc.getMessage()
				);
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// other exception, unhandled exception, catch all
	@ExceptionHandler
	public ResponseEntity<SimpleErrorResponse> handle(Exception exc){
		System.out.println(exc.getMessage());
		SimpleErrorResponse error = new SimpleErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				exc.getMessage()
			);
	
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}

}
