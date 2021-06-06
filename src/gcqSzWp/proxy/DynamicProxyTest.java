package gcqSzWp.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
	public static void main(String[] args) {
		System.out.println("==========方法一==========");
		AdminService adminService = new AdminServiceImpl();
		System.out.println("代理的目标对象：" +adminService.getClass());
		
		AdminServiceInvocation adminServiceInvocation = new AdminServiceInvocation(adminService);
		
		AdminService proxy =       
				(AdminService) new AdminServiceDynamicProxy(adminService,adminServiceInvocation).getPersonProxy();
		System.out.println("代理对象:"+proxy.getClass());
		
		Object obj = proxy.find();
		System.out.println("find 返回对象:"+obj.getClass());
        System.out.println("----------------------------------");
        proxy.update();
        
        //方法二
        System.out.println("============ 方法二 ==============");
        AdminService target = new AdminServiceImpl();
        AdminServiceInvocation invocation = new AdminServiceInvocation(adminService);
        
        AdminService proxy2 = (AdminService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),invocation);
        Object obj2 = proxy2.find();
        System.out.println("find返回对象: " + obj2.getClass());
        System.out.println("-------------------------");
        proxy2.update();
        
		
	}
	
	

}
