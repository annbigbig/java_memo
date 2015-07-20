package com.kashu.demo;

import java.util.Scanner;

public class Homework01 {
/* 練習1
 * 讓用戶輸入10個整數，求陣列中最大的值，和陣列的平均值
 * 
 * 
 * 
 * 
 */
	public static void main(String[] args) {
		//variables declaration
		Scanner sc = new Scanner(System.in);
		int n[] = new int[10];
		int max = 0;
		double total = 0 , avg = 0;
		
		//collect data
		for(int i=0;i<10;i++){
			System.out.println("請輸入第" + (i+1) + "個整數");
			n[i] = sc.nextInt();
		}
		
		//calculating
		max = n[0];
		for(int j=0;j<10;j++){
			total += n[j];
			System.out.print("n[" + j + "]=" + n[j] + "\n");
			if(max<n[j]) max = n[j];
		}
		avg = (total / 10);
		
		//display results

		System.out.println("最大的值 = " + max);
		System.out.println("平均值 = " + avg);

	}

}