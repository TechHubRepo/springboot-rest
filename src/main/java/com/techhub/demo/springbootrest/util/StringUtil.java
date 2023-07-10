package com.techhub.demo.springbootrest.util;

/**
 * The ObjectUtil
 * 
 * @author ramniwash
 */
public final class StringUtil {

	private StringUtil() {
	}

	/**
	 * Return true if String is empty
	 * 
	 * @param str the String
	 * @return boolean
	 */
	public static final boolean isEmpty(String str) {
		return str == null ? true : str.isEmpty();
	}

	/**
	 * Return true if String is blank
	 * 
	 * @param str the String
	 * @return boolean
	 */
	public static final boolean isBlank(String str) {
		return str == null ? true : str.isBlank();
	}
}
