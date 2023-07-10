package com.techhub.demo.springbootrest.repository;

import java.util.Set;

import com.techhub.demo.springbootrest.exception.DirectoryContactException;
import com.techhub.demo.springbootrest.model.DirectoryContact;

/**
 * The DirectoryContactRepository
 * 
 * @author ramniwash
 */
public interface DirectoryContactRepository {

	/**
	 * Save a new DirectoryContact
	 * 
	 * @param directoryContact the DirectoryContact
	 * @return long
	 */
	public long save(DirectoryContact directoryContact) throws DirectoryContactException;

	/**
	 * Return DirectoryContact by contactId
	 * 
	 * @param contactId the long
	 * @return the DirectoryContact
	 */
	public DirectoryContact get(long contactId) throws DirectoryContactException;

	/**
	 * Get multiple DirectoryContact
	 * 
	 * @param offset the int
	 * @param limit  the int
	 * @return the Set of DirectoryContact
	 */
	public Set<DirectoryContact> getContacts(int offset, int limit) throws DirectoryContactException;

	/**
	 * Update the DirectoryContact
	 * 
	 * @param directoryContact
	 * @return boolean
	 * @throws DirectoryContactException
	 */
	public DirectoryContact update(DirectoryContact directoryContact) throws DirectoryContactException;

	/**
	 * Delete the directory contact
	 * 
	 * @param contactId
	 * @return
	 * @throws DirectoryContactException
	 */
	public DirectoryContact delete(long contactId) throws DirectoryContactException;
}
