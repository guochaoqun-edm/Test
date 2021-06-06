package gcq.hw;

import java.util.Scanner;

public class StringNiXu {
	
	public static String fun1(String str) {
		char[] arr = str.toCharArray();
		for(int i =0; i <arr.length/2;i++) {
			char temp;
			temp = arr[i];
			arr[i] =arr[arr.length-i-1];
			arr[arr.length-i-1] =temp;
			
		}
		return new String(arr);
	}
	
	public static String fun2(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
//        String str = "I am a student";
    	String str =sc.nextLine();
        System.out.println(fun1(str));
    }

}
