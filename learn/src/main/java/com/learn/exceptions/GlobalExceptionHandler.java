package com.learn.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learn.payloads.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message = ex.getMessage();
		APIResponse apiresponse=new APIResponse(message,false); 
		return new ResponseEntity<APIResponse>(apiresponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String,String> error=new HashMap<>();
		 ex.getBindingResult().getAllErrors().forEach((er)->{
			 String fieldname = ((FieldError)er).getField();
			 String message = er.getDefaultMessage();
			 error.put(fieldname, message);
		 });
		return new ResponseEntity<Map<String,String>>(error,HttpStatus.BAD_REQUEST);
	}
	

}
