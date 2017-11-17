package com.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Agent implements InvocationHandler {
	
	private Object target;
	
	public Object newInstance(Object arg0){
		this.target = arg0;
		return Proxy.newProxyInstance(arg0.getClass().getClassLoader(), arg0.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object object, Method method, Object[] arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		before();
		Object o = method.invoke(target, arg2);
		after();
		return o;
	}
	
	
	public void before(){
		System.out.println("before.");
	}
	
	public void after(){
		System.out.println("after.");
	}
	
	
}
