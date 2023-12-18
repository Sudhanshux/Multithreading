package com.example.util;

public class StringUtil {
	
	
	
	public static boolean isNullOrEmpty(String str) {
		if(str == null) return true;
		if("".equals(str.trim())) return true;
		return false;
	}

}
