package gcq.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ListAdd6 {
	
	
	private static List list = new ArrayList();
	
	public void add() {
		list.add("bfxy");
	}
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		final ListAdd6 list2 = new ListAdd6();
		
		final CountDownLatch latch = new CountDownLatch(1);
		
		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
						for(int i = 0; i <10;i++) {
							list2.add();
							System.out.println("当前线程: "+Thread.currentThread().getName()+"添加一个元素..");
							Thread.sleep(500);
							if(list.size()==5) {
								System.out.println("已经发出了唤醒通知!");
								//唤醒B线程
								latch.countDown();
							}
						}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"A");
		
		
		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
						if(list2.size()!=5) {
							try {
								latch.await();
							}catch(InterruptedException e) {
								e.printStackTrace();
							}
						}
							System.out.println("当前线程收到通知: "+Thread.currentThread().getName()+"list size =5;B线程停止");
							throw new RuntimeException();

					
				}

			}
			
		},"B");
		
		B.start();
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		A.start();

		
	}

}
