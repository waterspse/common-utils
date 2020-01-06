package com.ryg.common.utils;
/**
 * 字符串工具类
 * @author lenovo
 *
 */
public class StringUtil {

	public static boolean isNULL(String str) {
		if(str==null || "".equals(str)){
			return true;
		}
		return false;
		/**
		 * 去空格后，如果为"",返回true
		 */
		 str = str.trim();
		if("".equals(str)) {
			return true;
		}
		return false;
	}
}
