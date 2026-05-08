package com.kodewala.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserEmailAlreadyExistException.class)
	public ResponseEntity  handleUserException(UserEmailAlreadyExistException exception) {
		
		System.out.println(" Controller UserEmailAlreadyExistException block........");
		
		Map<String, Object>response=new HashMap<>();
		response.put("Status", HttpStatus.FOUND);
		response.put("message", exception.getMessage());
		return ResponseEntity.ok().body(response);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body(errors);
    }
	
	//user not found
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity  handleUserNotFoundException(UserNotFoundException exception) {
		
		System.out.println(" Controller UserNotFoundException block........");
		
		Map<String, Object>response=new HashMap<>();
		response.put("Status", HttpStatus.NOT_FOUND);
		response.put("message", exception.getMessage());
		return ResponseEntity.ok().body(response);
		
	}
}
