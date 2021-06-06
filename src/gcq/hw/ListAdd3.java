package gcq.hw;

import java.util.ArrayList;
import java.util.List;

public class ListAdd3 {
	

	private volatile static List list = new ArrayList();
	
	public void add() {
		list.add("bfxy");
	}
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		final ListAdd3 list3 = new ListAdd3();
		final Object lock = new Object();
		
		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
						for(int i = 0; i <10;i++) {
							list3.add();
							System.out.println("当前线程: "+Thread.currentThread().getName()+"添加一个元素..");
							Thread.sleep(500);
//							if(list.size()==5) {
//								System.out.println("已经发出了唤醒通知!");
//								//唤醒B线程
//								lock.notify();
//							}
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
						if(list3.size()==5) {
							System.out.println("当前线程收到通知: "+Thread.currentThread().getName()+"list size =5;B线程停止");
							throw new RuntimeException();
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
