package com.kashu.demo;

import java.util.Scanner;

public class Fibonacci_Recursive_Sum {

	//費氏數列 1 , 1 , 2 , 3 , 5 , 8 , 13 ....
	//遞迴呼叫函式(Recursive Function Call)求費氏數列第1項加總至費氏數列第n項
	
	public static void main(String[] args) {
		//variables declaration
		Scanner sc = new Scanner(System.in);
		int n = 1 , fn = 0 , total = 0;
		
		//collect data
		System.out.println("請問要從費氏數列第1項加總到費氏數列第幾項呢？");
		n = sc.nextInt();
		
		//calculating
		if(n<=1) n = 1;
		for(int i=1;i<=n;i++){
			fn = fibonacci(i);
			total += fn;
		}
		
		//display results
		System.out.println("從費氏數列第1項加總到費氏數列第" + n+"項 = " + total);
	}

	public static int fibonacci(int n){
		if((n==1)||(n==2)){
			return 1;
		}
		return (fibonacci(n-1) + fibonacci(n-2));
	}

}
