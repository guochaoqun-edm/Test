package gcqSzWp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AdminServiceInvocation implements  InvocationHandler{
	
	private Object target;
	
	public AdminServiceInvocation(Object target) {
		this.target = target;
		
	}
	
	public Object invoke(Object proxy,Method method,Object[] args )
	 throws Throwable{
		System.out.println("�ж��û��Ƿ���Ȩ�޽��в���");
		Object obj = method.invoke(target);
		System.out.println("��¼�û�ִ�в������û���Ϣ���������ݺ�ʱ��");
		return obj;
	}

}
