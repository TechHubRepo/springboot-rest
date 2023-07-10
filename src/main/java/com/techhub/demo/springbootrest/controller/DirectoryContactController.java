package com.techhub.demo.springbootrest.controller;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.demo.springbootrest.constants.Message;
import com.techhub.demo.springbootrest.dto.DirectoryContactDto;
import com.techhub.demo.springbootrest.dto.ServiceResponse;
import com.techhub.demo.springbootrest.exception.DirectoryContactException;
import com.techhub.demo.springbootrest.service.DirectoryContactService;
import com.techhub.demo.springbootrest.util.ObjectUtil;

/**
 * The DirectoryContactController
 * 
 * @author ramniwash
 */
@RestController("directoryContactController")
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST})
public class DirectoryContactController {

	/** The Constant LOGGER */
	private static final Logger LOGGER = LogManager.getLogger(DirectoryContactController.class);

	/** The DirectoryContactService */
	@Autowired
	private DirectoryContactService directoryContactService;

	@GetMapping(value = { "/get-contact/{contactId}" }, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ServiceResponse<DirectoryContactDto> getDirectoryContact(@PathVariable("contactId") long contactId)
			throws DirectoryContactException {
		LOGGER.info(":::: GETTING DIRECTORY CONTACT ::::");
		DirectoryContactDto directoryContactDto = this.directoryContactService.getDirectoryContact(contactId);
		ServiceResponse<DirectoryContactDto> response = new ServiceResponse<>();
		if (ObjectUtil.isObjectNotNull(directoryContactDto)) {
			response.setMessage(Message.ONE_RECORD_FOUND);
			response.setValue(directoryContactDto);
		} else {
			response.setMessage(Message.NO_RECORD_FOUND);
		}
		return response;
	}

	@GetMapping(value = { "/get-contacts" }, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ServiceResponse<Set<DirectoryContactDto>> getDirectoryContacts(@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) throws DirectoryContactException {
		LOGGER.info(":::: GETTING DIRECTORY CONTACTS ::::");
		Set<DirectoryContactDto> directoryContactDtos = this.directoryContactService.getDirectoryContacts(offset,
				limit);
		ServiceResponse<Set<DirectoryContactDto>> response = new ServiceResponse<>();
		if (ObjectUtil.isObjectNotNull(directoryContactDtos)) {
			response.setMessage(directoryContactDtos.size() +" "+Message.RECORDS_FOUND);
			response.setValue(directoryContactDtos);
		} else {
			response.setMessage(Message.NO_RECORD_FOUND);
		}
		return response;
	}

	@GetMapping(value = { "/get-contacts2/{ids}" }, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ServiceResponse<Set<DirectoryContactDto>> getDirectoryContactsByIds(
			@MatrixVariable(pathVar = "ids") List<Long> ids) throws DirectoryContactException {
		LOGGER.info(":::: GETTING DIRECTORY CONTACTS BY IDS ::::");
		Set<DirectoryContactDto> directoryContactDtos = this.directoryContactService.getDirectoryContacts(ids);
		ServiceResponse<Set<DirectoryContactDto>> response = new ServiceResponse<>();
		if (ObjectUtil.isObjectNotNull(directoryContactDtos)) {
			response.setMessage(directoryContactDtos.size() + " records found");
			response.setValue(directoryContactDtos);
		} else {
			response.setMessage(Message.NO_RECORD_FOUND);
		}
		return response;
	}

	@PostMapping(value = { "/add-contact" }, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ServiceResponse<?> addDirectoryContact(@RequestBody DirectoryContactDto directoryContactDto)
			throws DirectoryContactException {
		LOGGER.info(":::: ADDING DIRECTORY CONTACT ::::");
		long id = directoryContactService.addDirectoryContact(directoryContactDto);
		return new ServiceResponse<>("Directory Contact added", id);
	}

	@PutMapping(value = "/update-contact", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<DirectoryContactDto> updateDirectoryContact(
			@RequestBody DirectoryContactDto directoryContactDto) throws DirectoryContactException {
		LOGGER.info(":::: UPDATING DIRECTORY CONTACT ::::");
		DirectoryContactDto response = this.directoryContactService.updateDirectoryContact(directoryContactDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete-contact/{contactId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<DirectoryContactDto> deleteDirectoryContact(@PathVariable("contactId") long contactId)
			throws DirectoryContactException {
		LOGGER.info(":::: DELETING DIRECTORY CONTACT ::::");
		DirectoryContactDto response = this.directoryContactService.deleteDirectoryContact(contactId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
