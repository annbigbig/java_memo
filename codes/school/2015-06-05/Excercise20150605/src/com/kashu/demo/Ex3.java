package com.kashu.demo;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		
		//variable declaration
		int x = 0, y = 0 , result = 0;
		Scanner sc = new Scanner(System.in);
		
		//collect data
		System.out.println("請輸入整數x");
		x = sc.nextInt();
		System.out.println("請輸入整數y");
		y = sc.nextInt();
		
		//calculating
		result = compare(x,y);
		
		//display results
		System.out.println("比較大的整數 =" + result);
	}
	
	public static int compare(int a,int b){
		int bigger;
		if(a>b){
			bigger = a;
		}else{
			bigger = b;
		}
		return bigger;
	}

}