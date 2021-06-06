package gcq.hw;

public class CustomSyncThread extends Object{
	
    private static final String TAG = "CustomLock";

    public CustomSyncThread() {

    }

    synchronized public static void methodA() {
        try {
        	 System.out.println("MethodA ����");
            Thread.sleep(2000);
            System.out.println("MethodA �뿪");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void methodB() {
        try {
        	System.out.println("MethodB ����");
            Thread.sleep(2000);
            System.out.println("methodB �뿪");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodC() {
        try {
        	System.out.println("methodC ����");
            Thread.sleep(2000);
            System.out.println("methodC �뿪");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodD() {
        try {
        	System.out.println("methodD ����");
            Thread.sleep(2000);
            System.out.println("methodD �뿪");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
