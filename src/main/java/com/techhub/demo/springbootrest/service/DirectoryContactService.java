package com.techhub.demo.springbootrest.service;

import java.util.List;
import java.util.Set;

import com.techhub.demo.springbootrest.dto.DirectoryContactDto;
import com.techhub.demo.springbootrest.exception.DirectoryContactException;

/**
 * The DirectoryContactService
 * 
 * @author ramniwash
 */
public interface DirectoryContactService {

	/**
	 * Add new DirectoryContact
	 * 
	 * @param directoryContactDto
	 * @return
	 */
	public long addDirectoryContact(DirectoryContactDto directoryContactDto) throws DirectoryContactException;

	/**
	 * Get DirectoryContactDto
	 * 
	 * @param directoryContact
	 * @return
	 */
	public DirectoryContactDto getDirectoryContact(long contactId) throws DirectoryContactException;

	/**
	 * Return multiple DirectoryContactDto
	 * 
	 * @param offset the int
	 * @param limit  the int
	 * @return the Set of DirectoryContactDto
	 */
	public Set<DirectoryContactDto> getDirectoryContacts(int offset, int limit) throws DirectoryContactException;

	/**
	 * Return multiple DirectoryContactDto
	 * 
	 * @param ids
	 * @return
	 */
	public Set<DirectoryContactDto> getDirectoryContacts(List<Long> ids) throws DirectoryContactException;

	/**
	 * Delete the directory contact
	 * 
	 * @param contactId
	 * @return
	 * @throws DirectoryContactException
	 */
	public DirectoryContactDto deleteDirectoryContact(long contactId) throws DirectoryContactException;

	/**
	 * Updates the Directory contact
	 * @param directoryContactDto
	 * @return
	 * @throws DirectoryContactException
	 */
	public DirectoryContactDto updateDirectoryContact(DirectoryContactDto directoryContactDto)
			throws DirectoryContactException;
}
