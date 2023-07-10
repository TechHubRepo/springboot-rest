package com.techhub.demo.springbootrest.util;

/**
 * The ObjectUtil
 * 
 * @author ramniwash
 */
public final class ObjectUtil {

	private ObjectUtil() {
	}

	/**
	 * Return true if Object is null
	 * 
	 * @param obj the Object
	 * @return booleans
	 */
	public static final boolean isObjectNull(Object obj) {
		return obj == null ? true : false;
	}

	/**
	 * Return true if Object is not null
	 * 
	 * @param obj the Object
	 * @returnboolean
	 */
	public static final boolean isObjectNotNull(Object obj) {
		return obj == null ? false : true;
	}
}
