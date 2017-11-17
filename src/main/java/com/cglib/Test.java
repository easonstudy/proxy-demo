package com.cglib;

import net.sf.cglib.core.DebuggingClassWriter;

public class Test {
	public static void main(String[] args) {
		  System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:/box/cglib");   
		  
		Agent agent =new Agent();
		UserService u = (UserService)agent.newProxyInstance(UserService.class);
		u.add();
		u.delete(3);
	}
}
