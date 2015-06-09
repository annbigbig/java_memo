package com.kashu.demo;

public class ByValueOrByReference {

	public static void main(String[] args) {
		int a[] = new int[3];
		int b[] = {4,5,6};
		print(b);  //打印整數陣列b
		changeIt(b);//呼叫changeIt函數，把b陣列傳入，在該函數裡改變b陣列的值
		print(b);//再次打印整數陣列b

	}

	public static void changeIt(int[] c){
		for(int i=0;i<=2;i++){
			c[i] = i;
		}
	}
	
	public static void print(int[] d){
		for(int i=0;i<=2;i++){
			System.out.println("d[" + i + "]=" + d[i]);
		}
	}
}
