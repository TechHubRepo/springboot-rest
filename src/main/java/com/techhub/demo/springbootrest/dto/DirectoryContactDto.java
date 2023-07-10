package com.techhub.demo.springbootrest.dto;

import java.io.Serializable;

/**
 * The DirectoryContact
 * 
 * @author ramniwash
 */
public class DirectoryContactDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The contactId */
	private long contactId;

	/** The contactName */
	private String contactName;

	/** The countryCode */
	private String countryCode;

	/** The contactNumber */
	private long contactNumber;

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("{ contactId : ").append(contactId).append("}");
		return str.toString();
	}
}
