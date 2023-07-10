package com.techhub.demo.springbootrest.adaptor;

import java.util.HashSet;
import java.util.Set;

import com.techhub.demo.springbootrest.dto.DirectoryContactDto;
import com.techhub.demo.springbootrest.model.DirectoryContact;
import com.techhub.demo.springbootrest.util.ObjectUtil;

/**
 * The DirectoryContactAdaptor
 * 
 * @author ramniwash
 *
 */
public final class DirectoryContactAdaptor {

	private DirectoryContactAdaptor() {
	}

	/**
	 * Transfer data from DirectoryContactDto to DirectoryContact
	 * 
	 * @param directoryContactDto the DirectoryContactDto
	 * @return DirectoryContact
	 */
	public static final DirectoryContact toDirectoryContact(DirectoryContactDto directoryContactDto) {
		DirectoryContact directoryContact = new DirectoryContact();
		if (ObjectUtil.isObjectNotNull(directoryContactDto)) {
			directoryContact.setContactId(directoryContactDto.getContactId());
			directoryContact.setContactName(directoryContactDto.getContactName());
			directoryContact.setContactNumber(directoryContactDto.getContactNumber());
			directoryContact.setCountryCode(directoryContactDto.getCountryCode());
		}
		return directoryContact;
	}

	/**
	 * Transfer data from DirectoryContact to DirectoryContactDto
	 * 
	 * @param directoryContact
	 * @return
	 */
	public static final DirectoryContactDto toDirectoryContactDto(DirectoryContact directoryContact) {
		DirectoryContactDto directoryContactDto = new DirectoryContactDto();
		if (ObjectUtil.isObjectNotNull(directoryContact)) {
			directoryContactDto.setContactId(directoryContact.getContactId());
			directoryContactDto.setContactName(directoryContact.getContactName());
			directoryContactDto.setContactNumber(directoryContact.getContactNumber());
			directoryContactDto.setCountryCode(directoryContact.getCountryCode());
		}
		return directoryContactDto;
	}

	/**
	 * Transfer data from Set of DirectoryContact to Set DirectoryContactDto
	 * 
	 * @param directoryContact the Set of DirectoryContact
	 * @return the Set of DirectoryContactDto
	 */
	public static final Set<DirectoryContactDto> toDirectoryContactDto(Set<DirectoryContact> directoryContacts) {
		Set<DirectoryContactDto> directoryContactDtos = new HashSet<>();
		for (DirectoryContact directoryContact : directoryContacts) {
			directoryContactDtos.add(toDirectoryContactDto(directoryContact));
		}
		return directoryContactDtos;
	}

}
