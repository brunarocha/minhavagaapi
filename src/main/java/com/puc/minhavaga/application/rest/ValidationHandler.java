package com.puc.minhavaga.application.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.puc.minhavaga.application.response.ErrorResponse;
import com.puc.minhavaga.infrastructure.exception.BadRequestException;
import com.puc.minhavaga.infrastructure.exception.InternalServerErrorException;
import com.puc.minhavaga.infrastructure.exception.NotFoundException;
 
@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {
	
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {    	
    	Map<String, String> errors = new HashMap<String, String>();
    	
    	for (FieldError error : ex.getBindingResult().getFieldErrors()) {
    		errors.put(error.getField(), error.getDefaultMessage());
    	}
        
    	return ResponseEntity.badRequest().body(new ErrorResponse(errors));
    }
    
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<Object> handleDefaultInternalServerErrorException(InternalServerErrorException ex) {
    	return ResponseEntity.internalServerError().body(new ErrorResponse(ex.getMessage()));
    }
        
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleDefaultNotFoundException(NotFoundException ex) {
    	return ResponseEntity.notFound().build();
    }
    
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleDefaultBadRequestException(BadRequestException ex) {
    	return ResponseEntity.badRequest().body(new ErrorResponse(ex.getField(), ex.getMessage()));
    }
    
    @ExceptionHandler({UsernameNotFoundException.class, BadCredentialsException.class})
    public ResponseEntity<Object> handleDefaultBadCredentialsException(BadCredentialsException ex) {
    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("Email ou senha incorretos!"));
    }
    
}