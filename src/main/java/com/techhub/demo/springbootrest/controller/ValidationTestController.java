package com.techhub.demo.springbootrest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.demo.springbootrest.dto.ValidationTestDao;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

/**
 * The ValidationTestController
 * 
 * @author ramniwash
 */
@Validated
@RestController
public class ValidationTestController {

	/**
	 * The Payload validation test case
	 * 
	 * @param validationTestDao
	 * @param errors
	 * @return
	 */
	@PostMapping(value = { "/validation-test" }, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> testValidation(@Valid @RequestBody ValidationTestDao validationTestDao, Errors errors) {
		
		if (errors.hasErrors()) {			
			List<FieldError> fieldErrors = errors.getFieldErrors();
			StringBuilder messages = new StringBuilder();
			for (FieldError fieldError : fieldErrors) {
				messages.append(fieldError.getField()).append(":");
				messages.append(fieldError.getDefaultMessage()).append(",\n");
			}
			return new ResponseEntity<>(messages, HttpStatus.FAILED_DEPENDENCY);
		}
		return new ResponseEntity<>(validationTestDao, HttpStatus.OK);
	}
	
	@GetMapping(value = {"/validate-req-param/{parm1}"})
	public ResponseEntity<String> testRequestParam(@Pattern(regexp = "[A-Z]+",message = "Should contains upper case character only") @PathVariable(name = "parm1") String parm1){
		return new ResponseEntity<>(parm1, HttpStatus.OK);
	}
	
	@GetMapping(value = {"/validate-req-param2"})
	public ResponseEntity<String> testRequestParam2(@Min(value = 1000000000l,message = "Mobile Number must be of 10 Digits") @Digits(integer = 10,message = "Mobile Number must be of 10 Digits" ,fraction = 0) @RequestParam("mobileNumber") long mobileNumber){
		return new ResponseEntity<>(String.valueOf(mobileNumber), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/validate-req-param3/{parm1}"})
	public ResponseEntity<String> testRequestParam3(
			@Pattern(regexp = "[A-Z]+",message = "Should contains upper case character only") @PathVariable(name = "parm1") String parm1,
			@Min(value = 1000000000l,message = "Mobile Number must be of 10 Digits") 
			@Digits(integer = 10,message = "Mobile Number must be of 10 Digits" ,fraction = 0) @RequestParam("mobileNumber") long mobileNumber){
		return new ResponseEntity<>(String.valueOf(parm1+": "+mobileNumber), HttpStatus.OK);
	}
}
