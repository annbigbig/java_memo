package com.kashu.demo;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
		//variables declaration
				Scanner sc = new Scanner(System.in);
				int n = 1 , result = 1;
				
	 //collect data
				System.out.println("請輸入一個整數，稍後會算出其1 * 2 * 3 * ..... * n 的結果");
				n = sc.nextInt();

	 //calculating
				if(n<0) n=1;
				for(int i=1;i<=n;i++){
					result = result * i;
				}
				
	 //display results
				System.out.println("整數" + n + "的階層是:" + result);
	}

}