package com.techhub.demo.springbootrest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techhub.demo.springbootrest.dto.DirectoryContactDto;
import com.techhub.demo.springbootrest.dto.ServiceResponse;


/**
 * The RestClientController
 * 
 * @author ramniwash
 */
@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestClientController {

	/**
	 * The GET URL test by Spring Rest Client
	 * 
	 * @return ResponseEntity of String
	 */
	@GetMapping(value = {"/rest-client-get"} , produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> getURLTest() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:4300/telephone-directory/get-contacts?offset=3&limit=10";		
		ResponseEntity<String> response= restTemplate.getForEntity(url, String.class);
		System.out.println("Body : " + response.getBody());
		return ResponseEntity.ok(response.toString());
	}

	/**
	 * The POST URL test by Spring Rest Client
	 * 
	 * @return ResponseEntity of String
	 */
	@GetMapping(value = {"/rest-client-post"}, produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> postURLTest() {
		DirectoryContactDto directoryContactDto = new DirectoryContactDto();
		directoryContactDto.setContactId(1255l);
		directoryContactDto.setContactName("ABCD");
		directoryContactDto.setContactNumber(3692581470l);
		String url = "http://localhost:4300/telephone-directory/add-contact";		
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("rawtypes")
		ResponseEntity<ServiceResponse> response = restTemplate.postForEntity(url, directoryContactDto, ServiceResponse.class);
		
		System.out.println("Status code :" + response.getStatusCode());
		System.out.println("Body             :" + response.getBody());
		return ResponseEntity.ok(response.toString());
	}
}
