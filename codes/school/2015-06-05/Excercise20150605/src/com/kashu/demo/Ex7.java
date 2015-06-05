package com.kashu.demo;

import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) {
		//variables declaration
		Scanner sc = new Scanner(System.in);
		int n = 2 , total = 0;
		
		//collect data
		do{
			System.out.println("請輸入一個正偶數 : ");
			n = sc.nextInt();
		}while((n<=0)||(n%2!=0));
		
		//calculating
		for(int i=2;i<=n;i+=2){
			total += i;
			if(i!=n){
				System.out.printf("%d + ", i);
			}else{
				System.out.printf("%d ", i);
			}
		}
		
		//display results
		System.out.printf(" = %d", total);
	}

}
