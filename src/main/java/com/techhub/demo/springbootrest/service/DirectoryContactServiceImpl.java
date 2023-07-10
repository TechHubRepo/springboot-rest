package com.techhub.demo.springbootrest.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.demo.springbootrest.adaptor.DirectoryContactAdaptor;
import com.techhub.demo.springbootrest.dto.DirectoryContactDto;
import com.techhub.demo.springbootrest.exception.DirectoryContactException;
import com.techhub.demo.springbootrest.repository.DirectoryContactRepository;
import com.techhub.demo.springbootrest.util.ObjectUtil;

/**
 * The DirectoryContactServiceImpl
 * 
 * @author ramniwash
 */
@Service("directoryContactService")
public class DirectoryContactServiceImpl implements DirectoryContactService {

	@Autowired
	private DirectoryContactRepository directoryContactRepository;

	@Override
	public long addDirectoryContact(DirectoryContactDto directoryContactDto) throws DirectoryContactException {
		if (ObjectUtil.isObjectNotNull(directoryContactDto)) {
			return directoryContactRepository.save(DirectoryContactAdaptor.toDirectoryContact(directoryContactDto));
		}
		return 0;
	}

	@Override
	public DirectoryContactDto getDirectoryContact(long contactId) throws DirectoryContactException {
		return DirectoryContactAdaptor.toDirectoryContactDto(this.directoryContactRepository.get(contactId));
	}

	@Override
	public Set<DirectoryContactDto> getDirectoryContacts(int offset, int limit) throws DirectoryContactException {
		return DirectoryContactAdaptor
				.toDirectoryContactDto(this.directoryContactRepository.getContacts(offset, limit));
	}

	@Override
	public Set<DirectoryContactDto> getDirectoryContacts(List<Long> ids) throws DirectoryContactException {
		Set<DirectoryContactDto> contactDtos = new HashSet<>();
		for (long id : ids) {
			contactDtos.add(DirectoryContactAdaptor.toDirectoryContactDto(this.directoryContactRepository.get(id)));
		}
		return contactDtos;
	}

	@Override
	public DirectoryContactDto deleteDirectoryContact(long contactId) throws DirectoryContactException {
		return DirectoryContactAdaptor.toDirectoryContactDto(this.directoryContactRepository.delete(contactId));
	}

	@Override
	public DirectoryContactDto updateDirectoryContact(DirectoryContactDto directoryContactDto)
			throws DirectoryContactException {
		return DirectoryContactAdaptor.toDirectoryContactDto(this.directoryContactRepository
				.update(DirectoryContactAdaptor.toDirectoryContact(directoryContactDto)));
	}
}
