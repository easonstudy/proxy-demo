package com.dynamic;


public class Test {
	public static void main(String[] args) {
		//����$Proxy0��class�ļ�
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		
		Agent agent = new Agent();
		People boy = (People)agent.newInstance(new Boy());
		boy.eat();
		
		People girl = (People)agent.newInstance(new Girl());
		girl.eat();
	}
}
