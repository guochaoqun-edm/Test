package gcqSzWp.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
	public static void main(String[] args) {
		System.out.println("==========����һ==========");
		AdminService adminService = new AdminServiceImpl();
		System.out.println("�����Ŀ�����" +adminService.getClass());
		
		AdminServiceInvocation adminServiceInvocation = new AdminServiceInvocation(adminService);
		
		AdminService proxy =       
				(AdminService) new AdminServiceDynamicProxy(adminService,adminServiceInvocation).getPersonProxy();
		System.out.println("�������:"+proxy.getClass());
		
		Object obj = proxy.find();
		System.out.println("find ���ض���:"+obj.getClass());
        System.out.println("----------------------------------");
        proxy.update();
        
        //������
        System.out.println("============ ������ ==============");
        AdminService target = new AdminServiceImpl();
        AdminServiceInvocation invocation = new AdminServiceInvocation(adminService);
        
        AdminService proxy2 = (AdminService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),invocation);
        Object obj2 = proxy2.find();
        System.out.println("find���ض���: " + obj2.getClass());
        System.out.println("-------------------------");
        proxy2.update();
        
		
	}
	
	

}
