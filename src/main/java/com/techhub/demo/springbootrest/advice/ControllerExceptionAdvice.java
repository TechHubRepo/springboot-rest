package com.techhub.demo.springbootrest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.techhub.demo.springbootrest.dto.ServiceResponse;
import com.techhub.demo.springbootrest.exception.DirectoryContactException;

@RestControllerAdvice
public class ControllerExceptionAdvice {

	@ExceptionHandler(DirectoryContactException.class)
	public ResponseEntity<ServiceResponse<String>> telePhonDirExHandler(DirectoryContactException ex) {
		System.out.println("DirectoryContactException type Catched");
		ServiceResponse<String> responseMessage = new ServiceResponse<>();
		responseMessage.setMessage(ex.getMessage());
		return new ResponseEntity<>(responseMessage, HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ServiceResponse<String>> generalException(Exception ex) {
		System.out.println("Exception type Catched");
		ServiceResponse<String> responseMessage = new ServiceResponse<>();
		responseMessage.setMessage(ex.getMessage());
		return new ResponseEntity<>(responseMessage, HttpStatus.EXPECTATION_FAILED);
	}
}