package com.techhub.demo.springbootrest.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.techhub.demo.springbootrest.exception.DirectoryContactException;
import com.techhub.demo.springbootrest.model.DirectoryContact;
import com.techhub.demo.springbootrest.util.ObjectUtil;

/**
 * The DirectoryContactRepositoryImpl
 * 
 * @author ramniwash
 */
@Repository("directoryContactRepository")
public class DirectoryContactRepositoryImpl implements DirectoryContactRepository {

	/** The directoryContactMap */
	private Map<Long, DirectoryContact> directoryContactMap = new HashMap<>();

	private List<Long> ids = new ArrayList<>();

	public DirectoryContactRepositoryImpl() {
		directoryContactMap.put(1l, new DirectoryContact(1, "Ram Niwash", "+91", 2827278));
		directoryContactMap.put(2l, new DirectoryContact(2, "Shyam Das", "+91", 852532));
		directoryContactMap.put(3l, new DirectoryContact(3, "Krishana", "+91", 564463428));
		directoryContactMap.put(4l, new DirectoryContact(4, "John Day", "+91", 8987687));
		directoryContactMap.put(6l, new DirectoryContact(6, "Shruthi", "+91", 6882766));
		directoryContactMap.put(5l, new DirectoryContact(5, "Diwaker", "+91", 86686786));
		directoryContactMap.put(14l, new DirectoryContact(14, "Laxmi", "+91", 6868686));
		directoryContactMap.put(18l, new DirectoryContact(18, "Sheema", "+91", 4655));
		directoryContactMap.put(19l, new DirectoryContact(19, "Prem Kumar", "+91", 858758));
		directoryContactMap.put(21l, new DirectoryContact(21, "Naresh Kumar", "+91", 876));
		directoryContactMap.put(22l, new DirectoryContact(22, "Kuldeep Singh", "+91", 8767));
		directoryContactMap.put(26l, new DirectoryContact(26, "Purshtom Dass", "+91", 382878));
		directoryContactMap.put(56l, new DirectoryContact(56, "Sandeep Kumar", "+91", 6786));
		directoryContactMap.put(15l, new DirectoryContact(15, "Sajjan Kumar", "+91", 63876));
		directoryContactMap.put(17l, new DirectoryContact(17, "Sumit Kumar", "+91", 754255));
		directoryContactMap.put(7l, new DirectoryContact(7, "Naveen Kumar", "+91", 7846541564l));
		directoryContactMap.put(9l, new DirectoryContact(9, "Lakhan Rao", "+91", 54654676));
		this.ids.add(1l);
		this.ids.add(2l);
		this.ids.add(3l);
		this.ids.add(4l);
		this.ids.add(6l);
		this.ids.add(5l);
		this.ids.add(14l);
		this.ids.add(18l);
		this.ids.add(19l);
		this.ids.add(21l);
		this.ids.add(22l);
		this.ids.add(26l);
		this.ids.add(56l);
		this.ids.add(15l);
		this.ids.add(17l);
		this.ids.add(7l);
		this.ids.add(9l);
	}

	/** The currentId */
	private Long currentId = 1000l;

	@Override
	public long save(DirectoryContact directoryContact) throws DirectoryContactException {
		currentId = currentId + 1;
		directoryContact.setContactId(currentId);
		directoryContactMap.put(currentId, directoryContact);
		boolean flag = this.ids.add(currentId);
		if (flag) {
			return currentId;
		} else {
			throw new DirectoryContactException("DIRECTORY CONTACT NOT SAVED TRY AGAIN");
		}
	}

	@Override
	public DirectoryContact get(long contactId) throws DirectoryContactException {
		if (!this.directoryContactMap.containsKey(contactId)) {
			throw new DirectoryContactException("DIRECTORY CONTACT NOT FOUND");
		} else {
			return this.directoryContactMap.get(contactId);
		}
	}

	@Override
	public Set<DirectoryContact> getContacts(int offset, int limit) throws DirectoryContactException {
		Set<DirectoryContact> contacts = new HashSet<>();
		if (offset > ids.size()) {
			throw new DirectoryContactException("INVALID OFFSET VALUE : " + offset);
		}
		if (offset + limit >= ids.size() - 1) {
			limit = ids.size() - 1;
		}
		for (int i = offset; i < offset + limit; i++) {
			Long id = this.ids.get(i);
			DirectoryContact directoryContact = this.directoryContactMap.get(id);
			if (ObjectUtil.isObjectNotNull(directoryContact)) {
				contacts.add(directoryContact);
			}
		}
		return contacts;
	}

	@Override
	public DirectoryContact update(DirectoryContact directoryContact) throws DirectoryContactException {
		if (this.directoryContactMap.containsKey(directoryContact.getContactId())) {
			DirectoryContact directoryContact2 = this.directoryContactMap.get(directoryContact.getContactId());
			this.directoryContactMap.remove(directoryContact.getContactId(), directoryContact2);
			this.directoryContactMap.put(directoryContact.getContactId(),directoryContact);
			return directoryContact;
		} else {
			throw new DirectoryContactException("DIRECTORY CONTACT NOT FOUND");
		}
	}

	@Override
	public DirectoryContact delete(long contactId) throws DirectoryContactException {
		if (this.directoryContactMap.containsKey(contactId)) {
			DirectoryContact directoryContact2 = this.directoryContactMap.get(contactId);
			this.directoryContactMap.remove(contactId, directoryContact2);
			this.ids.remove(contactId);
			return directoryContact2;
		} else {
			throw new DirectoryContactException("DIRECTORY CONTACT NOT FOUND");
		}
	}
}
