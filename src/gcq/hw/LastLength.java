package gcq.hw;

import java.util.Scanner;

public class LastLength {
	
	private static void countLastWordLength(String str) {
		if(!str.isEmpty()) {
			String[] split = str.split(" ");
			String lastWord = split[split.length - 1];
			int length = lastWord.length();
			System.out.print(length);
		}
	}
	public static void main(String[] args) {
		new Thread(new Runnable() {
            @Override
            public void run() {
                CustomSyncThread.methodA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                CustomSyncThread.methodB();
            }
        }).start();

		
		
		
		
		
	}

}
