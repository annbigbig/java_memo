package com.kashu.demo;

import java.util.Scanner;

public class Fibonaci {

	public static void main(String[] args) {
		// 費氏數列第n項之值  1,1,2,3,5,8,13
		//到第n項的總和
		
		//variables declaration
		int n = 1 , f1 = 1, f2 = 1 , fn = 1 , s =0;
		Scanner sc = new Scanner(System.in);
		
		//collect data
		System.out.println("請輸入一個正整數n");
		n = sc.nextInt();
		
		//calculating
		fn = fibo(n);
		for(int i=n;i>=1;i--){
			s = s + fibo(i);
		}
		
		//display results
		System.out.println("f(" + n + ")=" + fn);
		System.out.println("費氏數列加總到第n項總和為" + s);

	}
	
	public static int fibo(int n){
		  int result = 1;
		  if(n>=3){
		   result = fibo(n-1) + fibo(n-2);
		     }
		  return result;
	}

}