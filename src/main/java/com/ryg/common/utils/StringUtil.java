package com.ryg.common.utils;
/**
 * �ַ���������
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
		 * ȥ�ո�����Ϊ"",����true
		 */
		 str = str.trim();
		if("".equals(str)) {
			return true;
		}
		return false;
	}
}
