package com.techhub.demo.springbootrest.model;

import java.io.Serializable;

/**
 * The DirectoryContact
 * 
 * @author ramniwash
 */
public class DirectoryContact implements Serializable {

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

	public DirectoryContact() {
	}

	public DirectoryContact(long contactId, String contactName, String countryCode, long contactNumber) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.countryCode = countryCode;
		this.contactNumber = contactNumber;
	}

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
		return "DirectoryContact [contactId=" + contactId + ", contactName=" + contactName + ", countryCode="
				+ countryCode + ", contactNumber=" + contactNumber + "]";
	}

}
