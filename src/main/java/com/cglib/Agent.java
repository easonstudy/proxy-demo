package com.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class Agent implements MethodInterceptor{
	private Enhancer enhancer = new Enhancer();  
	
	public Object newProxyInstance(Class arg0){
		enhancer.setSuperclass(arg0);	//
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		before();
		Object o = proxy.invokeSuper(obj, args);
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
