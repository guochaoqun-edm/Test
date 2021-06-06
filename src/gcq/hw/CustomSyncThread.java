package gcq.hw;

public class CustomSyncThread extends Object{
	
    private static final String TAG = "CustomLock";

    public CustomSyncThread() {

    }

    synchronized public static void methodA() {
        try {
        	 System.out.println("MethodA 进入");
            Thread.sleep(2000);
            System.out.println("MethodA 离开");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void methodB() {
        try {
        	System.out.println("MethodB 进入");
            Thread.sleep(2000);
            System.out.println("methodB 离开");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodC() {
        try {
        	System.out.println("methodC 进入");
            Thread.sleep(2000);
            System.out.println("methodC 离开");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodD() {
        try {
        	System.out.println("methodD 进入");
            Thread.sleep(2000);
            System.out.println("methodD 离开");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
