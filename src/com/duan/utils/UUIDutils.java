package com.duan.utils;

import java.util.UUID;

public class UUIDutils {
	public static String getID(){
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}	
}
