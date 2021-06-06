package gcq.hw;

import java.util.ArrayList;
import java.util.List;

public class ListAdd2 {
	
	
	private static List list = new ArrayList();
	
	public void add() {
		list.add("abc");
	}
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		final ListAdd2 list1 = new ListAdd2();
		final Object lock = new Object();
		
		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized(lock) {
						for(int i = 0; i <10;i++) {
							list1.add();
							System.out.println("当前线程: "+Thread.currentThread().getName()+"添加一个元素..");
							Thread.sleep(500);
							if(list.size()==5) {
								System.out.println("已经发出了唤醒通知!");
								//唤醒B线程
								lock.notify();
							}
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
					synchronized(lock){
						if(list1.size()!=5) {
							try {
								lock.wait();
							}catch(InterruptedException e) {
								e.printStackTrace();
							}
						}
//						if(list1.size()==5) {
							System.out.println("当前线程收到通知: "+Thread.currentThread().getName()+"list size =5;B线程停止");
							throw new RuntimeException();
//						}

					}
					
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
