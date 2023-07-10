package com.techhub.demo.springbootrest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The VersioningAPIDemoController
 * 
 * @author ramniwash
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VersioningAPIDemoController {


	//The Example of  URI Versioning	
	@GetMapping(value = {"/v1/get-info"}, produces = {MediaType.TEXT_PLAIN_VALUE})
	public String getInfo_V1() {
		return "API VERSION ::::: 1";
	}
	
	//The Example of  URI Versioning
	@GetMapping(value = {"/v2/get-info"}, produces = {MediaType.TEXT_PLAIN_VALUE})
	public String getInfo_V2() {
		return "API VERSION ::::: 2";
	}
	
	//Custom Header Versioning
	@GetMapping(value = {"/get-info"}, produces = {MediaType.TEXT_PLAIN_VALUE}, headers = {"API-VERSION=3"})
	public String getInfo_V3() {
		return "API VERSION ::::: 3";
	}
	
	//Custom Header Versioning
	@GetMapping(value = {"/get-info"}, produces = {MediaType.TEXT_PLAIN_VALUE}, headers = {"API-VERSION=4"})
	public String getInfo_V4() {
		return  "API VERSION ::::: 4";
	}
		
	//Accept Header Versioning
	@GetMapping(value = {"/get-info"}, produces = {"text/plain.app-v5"})
	public String getInfo_V5() {
		return "API VERSION ::::: 5";
	}
	
	//Accept Header Versioning
	@GetMapping(value = {"/get-info"}, produces = {"text/plain.app-v6"})
	public String getInfo_V6() {
		return "API VERSION ::::: 6";
	}
	
	//Request Parameter Versioning
	@GetMapping(value = {"/get-info"}, produces = {"text/plain"}, params = {"version=7"})
	public String getInfo_V7() {
		return "API VERSION ::::: 7";
	}
	
	//Request Parameter Versioning
	@GetMapping(value = {"/get-info"}, produces = {"text/plain"},params = {"version=8"})
	public String getInfo_V8() {
		return "API VERSION ::::: 8";
	}
}
