package com.techhub.demo.springbootrest.exception;

/**
 * The DirectoryContactException
 * 
 * @author ramniwash
 */
public class DirectoryContactException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DirectoryContactException() {
		super();
	}

	public DirectoryContactException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);	
	}

	public DirectoryContactException(String message, Throwable cause) {
		super(message, cause);
	}

	public DirectoryContactException(String message) {
		super(message);
	}

	public DirectoryContactException(Throwable cause) {
		super(cause);
	}

}
