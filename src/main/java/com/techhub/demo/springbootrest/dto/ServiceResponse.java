package com.techhub.demo.springbootrest.dto;

/**
 * The DirectoryContactResponse
 * 
 * @author ramniwash
 * @param <T>
 */
public class ServiceResponse<T> {

	/** The message */
	private String message;

	/** The value */
	private T value;

	/** The Default constructor */
	public ServiceResponse() {
	}

	/** The Constructor 2 */
	public ServiceResponse(String message, T value) {
		this.message = message;
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
