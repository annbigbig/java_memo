package com.kashu.demo;

import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		//variable declaration
		Scanner sc = new Scanner(System.in);
		int x = 0 , total = 0;
		
		//collect data
		System.out.println("請輸入一個整數 :");
		x = sc.nextInt();
		
		//calculating
		total = ArithmeticSeries(x); 
		
		//display results
   System.out.printf(" = %d",total);
	}

	public static int ArithmeticSeries(int n){
		int result = 0;
		for(int i=1;i<=n;i++){
			if(i!=n){
   			System.out.printf("%d + ", i);
			}else{
				  System.out.printf("%d ", i);
			}
			result += i;
		}
		return result;
	}
}