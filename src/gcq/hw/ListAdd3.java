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
							System.out.println("��ǰ�߳�: "+Thread.currentThread().getName()+"���һ��Ԫ��..");
							Thread.sleep(500);
//							if(list.size()==5) {
//								System.out.println("�Ѿ������˻���֪ͨ!");
//								//����B�߳�
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
							System.out.println("��ǰ�߳��յ�֪ͨ: "+Thread.currentThread().getName()+"list size =5;B�߳�ֹͣ");
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
